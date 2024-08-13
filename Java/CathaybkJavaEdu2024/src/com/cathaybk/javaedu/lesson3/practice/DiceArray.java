package com.cathaybk.javaedu.lesson3.practice;

public class DiceArray {

	public static void main(String[] args) {
		diceArray();
	}

	private static void diceArray() {

		// index 0 1 2 3 4 5 6 7 8 9 10
		// 統計對象 2 3 4 5 6 7 8 9 10 11 12(兩顆骰子相加)
		String[] results = new String[] { "", "", "", "", "", "", "", "", "", "", "" };

		for (int i = 1; i <= 20; i++) {
			results[dice() + dice() - 2] += "*";
		}

		for (int i = 0; i < results.length; i++) {
			String result = results[i];
			if (!"".equals(result)) {// !代表是否定
			}
			System.out.println((i + 2) + result);

//!"".equals(result)是指否定結果為0            
//            if ("".equals(result)) {
//            	continue;//結果為0的時候跳過繼續進入迴圈
//            }
//            System.out.println((i + 2) + result);
		}
	}

	private static int dice() {
		return (int) (Math.random() * 10 % 6) + 1;
		// * 10 % 6 0 1 2 3 4 5
		// * 10 % 6 + 1 1 2 3 4 5 6
	}

}

//public class DiceArray {
//public static void main(String[] args) {
//	Random rand = new Random();
//	// result: 2 3 4 5 6...
//	//index:   0 1 2 3 4...
//	String[] results = new String[] {"","","","","","","","","","",""};
//	for (int i = 0; i<20; i++ );
//    int result1 = rand.nextInt(6)+1;
//    int result2 = rand.nextInt(6)+1;
//    int sum = result1+result2;
//    results[sum-2] = results[sum-2]+"*"; 
//}
//for(int i =0 ;i < results.length;i++) {
//	String result = results[i];
//	if ("".equals(result)) {
//		continue;
//	}
//}
//}
