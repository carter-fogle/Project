package com.fmt;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DataSerlizers {

	/**
	 * Prints a list of Items to a XML file
	 * 
	 * @param items
	 */
	public static void itemsToXML(List<Item> items) {
		
		XStream xstream = new XStream(new DomDriver());
		
		xstream.alias("Item", Item.class);
		xstream.alias("Equipment", Equipment.class);
		xstream.alias("Service", Service.class);
		xstream.alias("Product", Product.class);

		PrintWriter pw;
		try {
			
			pw = new PrintWriter(new File("data/Items.xml"));
			
			pw.println("<?xml version=\"1.0\" ?>");
			
			String xml = xstream.toXML(items).replace("list", "Items");
			
			pw.print(xml);
			pw.close();

		} catch (Exception e) {
			
			throw new RuntimeException("Error");
			
		}
	}
	
	/**
	 * Prints a list of Persons to a XML file
	 * 
	 * @param persons
	 */
	public static void personsToXML(List<Person> persons) {
		
		XStream xstream = new XStream(new DomDriver());
		
		xstream.alias("Person", Person.class);

		PrintWriter pw;
		try {
			
			pw = new PrintWriter(new File("data/Persons.xml"));
			
			pw.println("<?xml version=\"1.0\" ?>");
			
			String xml = xstream.toXML(persons).replace("list", "Persons");
			
			pw.print(xml);
			pw.close();

		} catch (Exception e) {
			
			throw new RuntimeException("Error");
			
		}
	}
	
	/**
	 * Prints a list of Stores to a XML file
	 * 
	 * @param stores
	 */
	public static void storesToXML(List<Store> stores) {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Store", Store.class);

		PrintWriter pw;
		try {
			
			pw = new PrintWriter(new File("data/Stores.xml"));
			
			pw.println("<?xml version=\"1.0\" ?> ");
			
			String xml = xstream.toXML(stores).replace("list", "Persons");
			pw.print(xml);
			pw.close();

		} catch (Exception e) {
			throw new RuntimeException("Error");
		}
	}
	
	/**
	 * Prints a list of Items to a JSON file
	 * 
	 * @param items
	 */
	public static void itemsToJSON(List<Item> items) {
		
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
		PrintWriter pw;
		
		try {
			
			pw = new PrintWriter(new File("data/Items.json"));
			
			String json = gson.toJson(items);
			JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
			String prettyJson = gson.toJson(jsonElement);
			
			pw.printf(prettyJson);
			pw.close();

		} catch (Exception e){
			
			throw new RuntimeException("Error");
			
		}
	}
	
	/**
	 * Prints a list of Persons to a JSON file
	 * 
	 * @param persons
	 */
	public static void personsToJSON(List<Person> persons) {
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("data/Persons.json"));
			String json = gson.toJson(persons);
			JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
			String prettyJson = gson.toJson(jsonElement);
			pw.printf(prettyJson);
			pw.close();

		} catch (Exception e){
			throw new RuntimeException("Error");
		}
	}
	
	/**
	 * Prints a list of Stores to a JSON file
	 * 
	 * @param stores
	 */
	public static void storesToJSON(List<Store> stores) {
		
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
		PrintWriter pw;
		
		try {
			
			pw = new PrintWriter(new File("data/Stores.json"));
			
			String json = gson.toJson(stores);
			JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
			String prettyJson = gson.toJson(jsonElement);
			
			pw.printf(prettyJson);
			pw.close();

		} catch (Exception e){
			
			throw new RuntimeException("Error");
			
		}
	}
}
