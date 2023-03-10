package com.fmt;
/**
 * This class represents an Product 
 * 	this class extends Item
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */

public class Product extends Item{

	protected final String name;
	protected final String unit;
	protected final double unitPrice;
	
	/**
	 * Constructor for type <code>Product</code>
	 * @param anc
	 * @param type
	 * @param name
	 * @param unit
	 * @param unitPrice
	 */
	public Product(String anc, String type, String name, String unit, double unitPrice) {
		super(anc, type);
		this.name = name;
		this.unit = unit;
		this.unitPrice = unitPrice;
	}

	public String getType() {
		return "P";
	}
	
	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public String toString() {
		return anc + "," + type + "," + name + "," + unit + "," + unitPrice;
	}
	
	
	
	
	
	
	
}
