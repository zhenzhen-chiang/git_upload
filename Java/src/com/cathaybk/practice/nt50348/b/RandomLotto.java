package com.cathaybk.practice.nt50348.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {
		Random ranlotto = new Random();
		List<Integer> list = new ArrayList<>();
		while (list.size() < 6) {
			int num = ranlotto.nextInt(49) + 1;
			if (!list.contains(num)) {
				list.add(num);
			}

		}
		System.out.print("排序前:");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
		System.out.println();

		Collections.sort(list);
		System.out.print("排序後:");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");

		}

	}
}
