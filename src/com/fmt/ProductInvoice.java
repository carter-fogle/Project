package com.fmt;

public class ProductInvoice implements InvoiceItem {
	
	private final Invoice invoice;
	private final Product product;
	private final double quantity;

	public ProductInvoice(Invoice invoice, Product product, double quantity) {
		this.invoice = invoice;
		this.product = product;
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Product getProduct() {
		return product;
	}
	
	public double getQuantity() {
		return quantity;
	}

	@Override
	public double getTotalPrice() {
		return this.getGrossPrice() + this.getTax();
	}
	
	@Override
	public double getTax() {
		return this.getGrossPrice() * 0.0715;
	}

	@Override
	public double getGrossPrice() {
		return this.product.getUnitPrice() * this.getQuantity();
	}

}
