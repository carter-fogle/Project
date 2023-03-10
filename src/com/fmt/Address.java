package com.fmt;
/**
 * This class represents an Address
 * 	this class extends Item
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */
 
public class Address {

	
	private final String street;
	private final String city;
	private final String state;
	private final String zip;
	private final String country;
	
	/**
	 * Constructor for type Address
	 * 
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 */
	public Address(String street, String city, String state, String zip, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return street + ","+ city + "," + state + ","+ zip + "," + country;
	}
}
