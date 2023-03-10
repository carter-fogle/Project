package com.fmt;

public class Purchase extends EquipmentInvoice {
	
	private final double totalPrice;

	public Purchase(Invoice invoice, Equipment equipment, String purchaceType, double totalPrice) {
		super(invoice, equipment, purchaceType);
		this.totalPrice = totalPrice;
	}

	@Override
	public double getGrossPrice() {
		return totalPrice;
	}
	
	@Override
	public double getTax() {
		return 0.0;
	}
}
