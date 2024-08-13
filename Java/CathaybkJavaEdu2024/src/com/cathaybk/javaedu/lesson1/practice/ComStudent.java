package com.cathaybk.javaedu.lesson1.practice;

public class ComStudent extends Student {

	public String program;
	
	public ComStudent() {
		super();
		System.out.println("沒有傳入參數的ComStudent建構子");
	}
	
	public ComStudent(String name, int id, int grade, String program) {
		super(name, id, grade);
		this.program = program;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("程式語言"+program);
	}
	
	

}
