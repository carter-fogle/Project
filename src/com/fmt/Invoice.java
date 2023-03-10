package com.fmt;

import java.time.LocalDate;
import java.util.Comparator;

public class Invoice {
	 
	private final String invNumber;
	private final Store store;
	private final Person customer;
	private final Person salesPerson;
	private final LocalDate invoiceDate;
	
	
	public Invoice(String invNumber, Store store, Person customer, Person salesPerson,
			LocalDate invoiceDate) {
		this.invNumber = invNumber;
		this.store = store;
		this.customer = customer;
		this.salesPerson = salesPerson;
		this.invoiceDate = invoiceDate;
	}


	public String getInvNumber() {
		return invNumber;
	}


	public Store getstore() {
		return store;
	}


	public Person getcustomer() {
		return customer;
	}


	public Person getsalesPerson() {
		return salesPerson;
	}


	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	
	public static final Comparator<Invoice> BY_ANC = new Comparator<>() {
		@Override
		public int compare(Invoice I1, Invoice I2) {
			return -(I1.getInvNumber().compareTo(I2.getInvNumber()));
		}
	};
	
}
