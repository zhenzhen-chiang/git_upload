package com.cathaybk.javaedu.lesson1.practice;

//public class School {
//
//	public static void main(String[] args) {
//		Student student = new Student();
//		student.print();
//		student.setName("Eric");
//		System.out.println();//空格
//		student.print();
//		System.out.println();//空格
//		System.out.println(student.getName());
//		student.setId(22222);
//		student.print();
//	}
//
//}


public class School {
    public static void main(String[] args) {
        LangStudent langStudent = new LangStudent();
        ComStudent comStudent = new ComStudent();
        System.out.println("--------------");
        LangStudent student1 = new LangStudent("小明", 88888, 1, "英文");
        ComStudent student2 = new ComStudent("小華", 77777, 2, "Java");
        student1.print();
        student2.print();
    }
}

