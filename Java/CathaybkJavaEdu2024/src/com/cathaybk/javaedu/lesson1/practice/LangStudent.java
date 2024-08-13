package com.cathaybk.javaedu.lesson1.practice;

public class LangStudent extends Student {

	public String language;

	public LangStudent() {
		super();
		System.out.println("沒有傳入參數的LanStudent建構子");
	}

	public LangStudent(String name, int id, int grade, String language) {
		super(name, id, grade);
		this.language = language;
	}

	

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("外語" + language);
	}

}