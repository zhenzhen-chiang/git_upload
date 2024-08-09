package com.cathaybk.practice.nt50348.b;

public class Employee implements IWok {
	private String name;
	private String department;
	private int salary;

	@Override
	public void printInfo() {
		System.out.println("薪資單");
		System.out.printf("姓名:%s 工作部門:%s\n", name, department);
	}

	public Employee() {

	}

	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
