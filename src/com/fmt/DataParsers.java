package com.fmt;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This file has various functions for Electronic Data Interchange for the FMT
 * project
 * 
 * @author Carter Fogle
 * @date 24-02-23
 */

public class DataParsers {
	
	public static List<Invoice> loadInvoices() {
		
		List<Invoice> invoices = new ArrayList<>();
		
		List<Store> stores = DataParsers.loadStores();
		Collections.sort(stores, Store.BY_ANC);
		
		List<Person> persons = DataParsers.loadPersons();
		Collections.sort(persons, Person.BY_ANC);
		
		String line = null;
		
		try (Scanner s = new Scanner(new File("data/Invoices.csv"))) {
			
			int numRecords = Integer.parseInt(s.nextLine());
			
			while (s.hasNextLine()) {
				line = s.nextLine();
				
				String tokens[] = line.split(",");
				
				Store storeKey = new Store(tokens[1]);
				int storeIndex = Collections.binarySearch(stores, storeKey, Store.BY_ANC);
			
				Store store = stores.get(storeIndex);
				
				Person customerKey = new Person(tokens[2]);
				int customerIndex = Collections.binarySearch(persons, customerKey, Person.BY_ANC);
				
				Person customer = persons.get(customerIndex);
				
				Person salesmanKey = new Person(tokens[3]);
				int salesmanIndex = Collections.binarySearch(persons, salesmanKey, Person.BY_ANC);

				Person salesman = persons.get(salesmanIndex);
				
				String dates[] = tokens[4].split("-");
				LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
				
				Invoice i = new Invoice(tokens[0], store, customer, salesman, date);
				
				invoices.add(i);
			}
			
		} catch ( Exception e ) {
			throw new RuntimeException("Error on " + line, e);
		}
		
		return invoices;
		
	}
	
	public static List<InvoiceItem> loadInvoiceItems(String fileName) {
		
		List<InvoiceItem> invoiceItems = new ArrayList<>();
		
		List<Item> items = loadItems();
		Collections.sort(items, Item.BY_ANC);
		
		List<Invoice> invoices = loadInvoices();
		Collections.sort(invoices, Invoice.BY_ANC);
		
		String line = null;
		
		try (Scanner s = new Scanner(new File(fileName))) {
			int numRecords = Integer.parseInt(s.nextLine());
			
			while (s.hasNextLine()) {
				
				line = s.nextLine();
				
				String tokens[] = line.split(",");

				
				
				
				
			}
		}
		
		
		return null;
	}
	
	
	

	/**
	 * Load type csv data for type Item
	 * 
	 * @param fileName
	 * @return list
	 */
	public static List<Item> loadItems() {

		List<Item> items = new ArrayList<>();
		String line = null;

		try (Scanner s = new Scanner(new File("data/Items.csv"))) {
			int numRecords = Integer.parseInt(s.nextLine());

			while (s.hasNextLine()) {
				
				line = s.nextLine();
				Item i = null;

				String tokens[] = line.split(",");

				if (tokens[1].equals("E")) {

					i = new Equipment(tokens[0], tokens[1], tokens[2], tokens[3]);

				} else if (tokens[1].equals("P")) {

					i = new Product(tokens[0], tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]));

				} else if (tokens[1].equals("S")) {

					i = new Service(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));

				} else {

					throw new RuntimeException("Bad data at " + line);
				}

				items.add(i);
			}

		} catch (Exception e) {
			throw new RuntimeException("Error on " + line, e);
		}

		return items;
	}

	/**
	 * Load type csv data for type Store
	 * 
	 * @param fileName
	 * @return list
	 */
	public static List<Store> loadStores() {

		List<Store> stores = new ArrayList<>();
		String line = null;

		try (Scanner s = new Scanner(new File("data/Stores.csv"))) {
			int numRecords = Integer.parseInt(s.nextLine());

			while (s.hasNextLine()) {

				line = s.nextLine();
				Store store = null;
				Person manager = null;
				Address address = null;

				String tokens[] = line.split(",");
				
				Person key = new Person(tokens[1]);
				List<Person> persons = loadPersons();
				Collections.sort(persons,Person.BY_ANC);
				int index = Collections.binarySearch(persons,key,Person.BY_ANC);

				manager = persons.get(index);

				address = new Address(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
				store = new Store(tokens[0], manager, address);

				stores.add(store);
			}

		} catch (Exception e) {

			throw new RuntimeException("Error on " + line, e);

		}

		return stores;
	}

	/**
	 * Load type csv data for type Person
	 * 
	 * @param fileName
	 * @return list
	 */
	public static List<Person> loadPersons() {

		List<Person> persons = new ArrayList<>();
		String line = null;

		try (Scanner s = new Scanner(new File("data/Persons.csv"))) {

			int numRecords = Integer.parseInt(s.nextLine());

			while (s.hasNextLine()) {

				line = s.nextLine();

				Person person = null;
				Address address = null;

				List<String> emails = new ArrayList<>();

				String tokens[] = line.split(",");

				address = new Address(tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);

				if (tokens.length == 8) {

					person = new Person(tokens[0], tokens[1], tokens[2], address);

				} else {

					for (int i = 8; i < tokens.length; i++) {
						emails.add(tokens[i]);
					}
					person = new Person(tokens[0], tokens[1], tokens[2], address, emails);

				}

				persons.add(person);
			}

		} catch (Exception e) {

			throw new RuntimeException("Error on " + line, e);

		}

		return persons;
	}
}