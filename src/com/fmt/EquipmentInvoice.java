package com.fmt;

public abstract class EquipmentInvoice implements InvoiceItem {
	
	private final Invoice invoice;
	private final Equipment equipment;
	private final String purchaceType;

	public EquipmentInvoice(Invoice invoice, Equipment equipment, String purchaceType) {
		this.invoice = invoice;
		this.equipment = equipment;
		this.purchaceType = purchaceType;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public String getPurchaceType() {
		return purchaceType;
	}
	
	@Override
	public double getTotalPrice() {
		return this.getGrossPrice() + this.getTax();
	}
	
	@Override
	public abstract double getTax();

	@Override
	public abstract double getGrossPrice();
}
