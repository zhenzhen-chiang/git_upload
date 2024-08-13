package com.cathaybk.practice.nt50348.b;

import java.math.BigDecimal;

public class Sales extends Employee {

	private int bouns;
	private int payment;

	public Sales(String name, String department, int salary, int performance) {
		super(name, department, salary);
		BigDecimal prf = new BigDecimal(performance);
		this.bouns = (prf.multiply(new BigDecimal(0.05))).intValue();
//		this.bouns = (int) (performance*0.05);
		this.payment = salary + bouns;

	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("業績獎金:" + bouns);
		System.out.println("總計:" + payment);

	}
}
