package com.cathaybk.javaedu.lesson3.practice;

import java.util.Random;

public class DiceArray1 {

	public static void main(String[] args) {
		diceArray1();
	}

	

	private static void diceArray1() {
		Random rand = new Random();
		                   // index 0  1  2  3  4  5 
				           // 統計對象 1  2  3  4  5  6 
		int[] results = new int[] { 0, 0, 0, 0, 0, 0 };//Array的int型別
		
		for (int i = 0; i < 5; i++) {
			int point = rand.nextInt(6) + 1;// point是骰子出來得數字
			int index = point - 1;// index位置
			results[index] = results[index] + 1;// 每骰一次要在index+1
//			System.out.println(results[index]);//int[] { 1, 0, 2, 2, 0, 0 }
			
		}
		
		for (int j = 1; j <= results.length; j++) {
//			System.out.println("擲了點數"+j+'='+  results[j-1]);
			int times = results[j-1];
			System.out.print(j);
			for (int s = 0; s <=times; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
//		}

//		for (int i = 0;  i< results.length; i++) {
//			int result = results[i];
//			System.out.println();
//		
//		// index 0 1 2 3 4 5 6 7 8 9 10
//		// 統計對象 1  2 3 4 5 6 7 8 9 10 11 12(兩顆骰子相加)
//		
//			for (int i = 0; i <= 20; i++) {
//			int result1 = rand.nextInt(6)+1;//第一顆骰子
//			int result2 = rand.nextInt(6)+1;//第二顆骰子
//			int sum = result1+ result2;
//			
//
//		}



