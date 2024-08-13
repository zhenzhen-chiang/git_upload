package com.cathaybk.javaedu.lesson3.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomList {

	public static void main(String[] args) {
		Random rand = new Random();
		Set<Integer> results = new TreeSet<>();
		while (results.size() < 15) {// results的結果15個
			results.add(rand.nextInt(100) + 1);
		}
		List<Integer> list = new ArrayList<Integer>(results);// 把set結果放入list
		int sum = 0;// 定義sum
		for (int i = 0; i < results.size(); i++) {
			System.err.println(sum);
			// [18,20,33,55...]，印出的結果是sum
			sum = sum + list.get(i);
		
		}
		System.out.println(results);
		System.out.println("平均數" + sum / results.size());//results.size()就是results的長度，就不寫15
	}
}