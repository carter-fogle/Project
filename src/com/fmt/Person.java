package com.fmt;

import java.util.Comparator;
import java.util.List;

/**
 * This class represents a Person
 * 
 * @author Carter Fogle
 * @date 24-02-23
 *
 */

public class Person {
	
	private final String anc;
	private final String firstName;
	private final String lastName;
	private final Address address;
	private final List<String> emails;
	
	/**
	 * Constructor for type <code>Person</code>
	 * 
	 * @param anc
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param emails
	 */
	public Person(String anc, String lastName, String firstName, Address address, List<String> emails) {
		this.anc = anc;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.emails = emails;
	}
	
	/**
	 * Constructor for type <code>Person</code> in the case that Person does not
	 * 	provide any emails
	 * 
	 * @param anc
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public Person(String anc, String lastName, String firstName, Address address) {
		this(anc, lastName, firstName, address, null);
	}
	
	/**
	 * Used in the case we are on provided the just the ANC for the person
	 * 
	 * @param anc
	 */
	public Person(String anc) {
		this(anc, null, null, null);
	}
	
	/**
	 * Comparator for Persons
	 * 
	 */
	public static final Comparator<Person> BY_ANC = new Comparator<>() {
		@Override
		public int compare(Person p1, Person p2) {
			return -(p1.getAnc().compareTo(p2.getAnc()));
		}
	};

	public String getAnc() {
		return anc;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public List<String> getEmails() {
		return emails;
	}

	@Override
	public String toString() {
		if(emails == null) {
			return anc + ","+ lastName + ","+ firstName + "," + "," + address.toString();
		} else {
			return anc + "," + lastName + ","+ firstName + "," + address.toString() + emails.toString();
		}
	}
	
	

	
}
