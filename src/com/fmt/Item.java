package com.fmt;

import java.util.Comparator;

/**
 * This is the abstract class that represents Item
 * 	Equipment, Product, and Service fall under this
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */

public abstract class Item {
	
	private final String anc;
	private final String type;
	
	/**
	 * Constructor for type Item
	 * 
	 * @param anc
	 * @param type
	 */
	public Item(String anc, String type) {
		super();
		this.anc = anc;
		this.type = type;
	}

	public String getAnc() {
		return anc;
	}
	
	public static final Comparator<Item> BY_ANC = new Comparator<>() {
		@Override
		public int compare(Item I1, Item I2) {
			return -(I1.getAnc().compareTo(I2.getAnc()));
		}
	};
	
	public abstract String getType();
	
	public abstract String toString(); 
}
