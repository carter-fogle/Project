package com.fmt;

public interface InvoiceItem {

	public abstract double getTax();

	public abstract double getGrossPrice();

	public abstract double getTotalPrice();
	
}
