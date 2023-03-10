package com.fmt;

public class ServiceInvoice implements InvoiceItem{
	
	private final Invoice invoice;
	private final Service service;
	private final double hoursWorked;

	public ServiceInvoice(Invoice invoice, Service service, double hoursWorked) {
		super();
		this.invoice = invoice;
		this.service = service;
		this.hoursWorked = hoursWorked;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Service getService() {
		return service;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	@Override
	public double getTax() {
		return this.getGrossPrice() * 0.0345;
	}

	@Override
	public double getGrossPrice() {
		return service.getHourlyRate() * this.hoursWorked;
	}
	
	

}
