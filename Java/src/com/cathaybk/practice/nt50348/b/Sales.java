package com.cathaybk.practice.nt50348.b;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sales extends Employee {

	private int bouns;
	private int payment;

	public Sales(String name, String department, int salary, int bouns) {
		super(name, department, salary);
		this.bouns = bouns;

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
		System.out.println("月薪:" + getSalary());
		BigDecimal bouns1 = BigDecimal.valueOf(bouns);
		BigDecimal salary1 = BigDecimal.valueOf(getSalary());
		BigDecimal bounsResult = bouns1.multiply(BigDecimal.valueOf(0.05)).setScale(0, RoundingMode.HALF_EVEN);
		System.out.println("業績獎金:" + bounsResult);
		BigDecimal paymentResult = salary1.add(bounsResult);
		System.out.println("總計:" + paymentResult);

	}
}
