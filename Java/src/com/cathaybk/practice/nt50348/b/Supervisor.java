package com.cathaybk.practice.nt50348.b;

public class Supervisor extends Employee {
	private int payment;

	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		payment = salary;
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
		System.out.println("總計:" + getSalary());

	}
}
