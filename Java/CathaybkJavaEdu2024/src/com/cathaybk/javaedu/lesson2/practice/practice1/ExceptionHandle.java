package com.cathaybk.javaedu.lesson2.practice.practice1;

public class ExceptionHandle {
//
//	public static void main(String[] args) {
//		try {
//			int number = (int) (Math.random() * 100 + 1);
//	
//			if (number % 2 == 1) {
//				System.out.println("奇數：" + number);
//			} else  { 
//					throw new Exception("偶數：" + number);
//			} 
//		}catch (Exception ex) {
//				ex.printStackTrace();
//			}
//				
//}
//}

	public static void main(String[] args) {
		int a = (int) (Math.random() * 100 + 1);
		
		try {
			if (a % 2 == 0) {
				throw new Exception("偶數：" + a);
			}
			else {
				System.out.println("奇數：" + a);
			}
		} catch ( Exception e) {
			e.printStackTrace();
	}
	}
}