package com.fmt;

import java.time.LocalDate;

public class Lease extends EquipmentInvoice{

	private final double monthlyPayment;
	private final LocalDate startDate;
	private final LocalDate endDate;
	
	public Lease(Invoice invoice, Equipment equipment, String purchaceType, double monthlyPayment, LocalDate startDate,
			LocalDate endDate) {
		super(invoice, equipment, purchaceType);
		this.monthlyPayment = monthlyPayment;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
	
	@Override
	public double getTax(){
		double total = this.getMonthlyPayment() * this.getLeaseLength();
		if(total <= 10000) {
			return 0.0;

		} else if(total >= 10000 && total < 100000){
			return 500.00;

		} else if(total >= 100000) {
			return 1500.00;
		} else {
			return -1;
		}
	}
	
	@Override
	public double getGrossPrice() {
		return this.getMonthlyPayment() * (this.getLeaseLength());
	}
	
	public double getLeaseLength() {
		return this.getStartDate().until(this.getEndDate()).toTotalMonths();
	}
}
