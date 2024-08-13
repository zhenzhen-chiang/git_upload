package com.cathaybk.practice.nt50348.b;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入介於1-12之間的整數:");
		int month = scanner.nextInt();

		LocalDate today = LocalDate.now();
		LocalDate firstDateOfMonth = today.withMonth(month).with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastDateOfMoonth = firstDateOfMonth.with(TemporalAdjusters.lastDayOfMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月");
		System.out.print("      " + firstDateOfMonth.format(formatter)+"\n");
		System.out.println("---------------------");
		System.out.println("日  一  二  三 四  五  六");
		System.out.println("=====================");
		int dayOfWeekStarIndex = firstDateOfMonth.getDayOfWeek().getValue();
		if (dayOfWeekStarIndex == 7) {
			dayOfWeekStarIndex = 0;
		}
		for (int i = 0; i < dayOfWeekStarIndex; i++) {
			System.out.print("   ");
		}
		LocalDate currentDay = firstDateOfMonth;
		while (!currentDay.isAfter(lastDateOfMoonth)) {
			System.out.printf("%2d ", currentDay.getDayOfMonth());
			if (currentDay.getDayOfWeek().getValue() ==6) {
				System.out.println();
			}
			currentDay = currentDay.plusDays(1);
		}
		if (currentDay.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
		scanner.close();
	}

}
