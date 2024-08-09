package com.cathaybk.practice.nt50348.b;

public class NineNineTable {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int n = i * j;
				System.out.print(j + "*" + i + "=" + n + "\t");

			}
			System.out.println();
		}

	}

}