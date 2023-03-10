package com.fmt;
/**
 * This class represents an Service 
 * 	this class extends Item
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */

public class Service extends Item{
	
	protected final String name;
	protected final double hourlyRate;
	
	public Service(String anc, String type, String name, double hourlyRate) {
		super(anc, type);
		this.name = name;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String getType() {
		return "S";
	}

	public String getName() {
		return name;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public String toString() {
		return this.getAnc() + "," + this.getType() + "," + name + "," + hourlyRate;
	}
}
