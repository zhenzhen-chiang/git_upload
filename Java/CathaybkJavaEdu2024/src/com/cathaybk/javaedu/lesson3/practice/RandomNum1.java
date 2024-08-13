package com.cathaybk.javaedu.lesson3.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNum1 {
	public static void main(String[] args) {
		doRandomSet();
	}

	public static void doRandomSet() {

		List<Integer> list = new ArrayList<>();// 放數字的的地方
		Random ran = new Random(); // 製造數字的機器

//		while (list.size() < 5) {
		for (int i = 0; i <=5; i++) {
			
		
		
			int num = ran.nextInt(10) + 1;// 產生出來的數字

			if (!list.contains(num)) {// list裡面不包含num
				list.add(num); // 把num放進list中
			} 

		}
		Collections.sort(list);//照著順序排列
		System.out.println(list);

	}
}
