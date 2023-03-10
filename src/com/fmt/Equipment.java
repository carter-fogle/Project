package com.fmt;
/**
 * This class represents an Equipment 
 * 	this class extends Item
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */

public class Equipment extends Item{

	private final String name;
	private final String model;
	
	/**
	 * Constructor for type Equipment
	 * 
	 * @param anc
	 * @param type
	 * @param name
	 * @param model
	 */
	public Equipment(String anc, String type, String name, String model) {
		super(anc, type);
		this.name = name;
		this.model = model;
	}

	@Override
	public String getType() {
		return "E";
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return anc + "," + type + "," + name + "," + model;
	}
}
