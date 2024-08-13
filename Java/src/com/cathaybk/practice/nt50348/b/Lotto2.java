package com.cathaybk.practice.nt50348.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto2 {

	public static void main(String[] args) {
		Random lottorand = new Random();
		List<Integer> list = new ArrayList<Integer>();
		while (list.size() < 6) {
			int num = lottorand.nextInt(49) + 1;
			list.add(num);
		}
		System.out.print("排序前:");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
		System.out.println();

		for (int i = 0; i < list.size() - 1; i++) {// 控制排序的輪數
			for (int k = 0; k < list.size() - 1 - i; k++) {// 內層循環對相鄰的兩個元素做比較和交換
				if (list.get(k) < list.get(k + 1)) {
					int temp = list.get(k);
					list.set(k, list.get(k + 1));//倆倆交換
					list.set(k + 1, temp);
				}
			}
		}
		System.out.println("排序後:");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");

		}
		System.out.println();

	}
}
