package com.cathaybk.practice.nt50348.b;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Calendar1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入介於1-12之間的整數:");
		int month = scanner.nextInt();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 M月");
		System.out.println("     " + sdf.format(calendar.getTime()));

		System.out.println("---------------------");
		System.out.println(" 日  一  二  三  四  五  六");
		System.out.println("=====================");
		int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
		int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 0; i < firstDayOfWeek; i++) {
			System.out.print("");
		}
		for (int day = 1; day <= dayOfMonth; day++) {
			System.out.printf("%3d", day);
			firstDayOfWeek++;
		if (firstDayOfWeek == 7) {
			System.out.println();
			firstDayOfWeek = 0;
		}
		scanner.close();
	}

	}}
