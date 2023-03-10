package com.fmt;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is the main driver for loading and outputting
 * 
 * @author Carter Fogle 
 * @date 24-02-23
 */

@SuppressWarnings("unused")
public class DataConverter {
	
	public static void main(String args[]) {
		
		List<Item> items = new ArrayList<>();
		items = DataParsers.loadItems();
		DataSerlizers.itemsToJSON(items);
		DataSerlizers.itemsToXML(items);
		
		List<Store> stores = new ArrayList<>();
		stores = DataParsers.loadStores();
		DataSerlizers.storesToXML(stores);
		DataSerlizers.storesToJSON(stores);
		
		List<Person> persons = new ArrayList<>();
		persons = DataParsers.loadPersons();
		DataSerlizers.personsToXML(persons);
		DataSerlizers.personsToJSON(persons);
	}
}
