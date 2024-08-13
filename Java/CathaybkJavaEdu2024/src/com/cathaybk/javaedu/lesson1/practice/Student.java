package com.cathaybk.javaedu.lesson1.practice;

public class Student implements IPrint {

	private String name = "Jason";

	private int id = 8888;

	private int grade = 1;


	@Override
	public void print() {
		System.out.printf("學生姓名：%s,學號：%d,年級：%d%n", name, id, grade);

	}
	
	public Student() {
	}

	public Student(String name, int id, int grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
		
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
