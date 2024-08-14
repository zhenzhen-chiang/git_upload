package com.cathaybk.practice.nt50348.b;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {// 上傳前在F一次
		try (Scanner scanner = new Scanner(System.in);) {// try with resource
			int month;
			while (true) {
				try {
					System.out.println("輸入介於1-12之間的整數:");
					month = scanner.nextInt();
					// 建立一個判斷，輸入只能在1-12之間try catch
					if (month >= 1 && month <= 12) {
						break;
					} else {
						System.out.println("錯誤，輸入數值不在1-12之間");
					}
				} catch (InputMismatchException e) {
					scanner.next();// 清除之前輸入的數值，重新輸入
				}
			}

			LocalDate today = LocalDate.now();
			LocalDate firstDateOfMonth = today.withMonth(month).with(TemporalAdjusters.firstDayOfMonth());
			LocalDate lastDateOfMoonth = firstDateOfMonth.with(TemporalAdjusters.lastDayOfMonth());// len
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月");
			System.out.print("      " + firstDateOfMonth.format(formatter) + "\n");
			System.out.println("---------------------");
			System.out.println("日  一  二  三 四  五  六");
			System.out.println("=====================");
			int dayOfWeekStarIndex = firstDateOfMonth.getDayOfWeek().getValue();// 獲取月份的第一天是星期幾(要從index裡面get出value)
			if (dayOfWeekStarIndex == 7) {
				dayOfWeekStarIndex = 0;// 將星期天的位置換到index0
			}
			for (int i = 0; i < dayOfWeekStarIndex; i++) {
				System.out.print("   ");// 根據星期幾換算出前面需要幾個空格
			}
			while (!firstDateOfMonth.isAfter(lastDateOfMoonth)) {// while迴圈會持續到firstDateOfMonth超過lastDateOfMoonth才會停下
				System.out.printf("%2d ", firstDateOfMonth.getDayOfMonth());// 限制格式列印這個月
				if (firstDateOfMonth.getDayOfWeek().getValue() == 6) {// 如果值是星期六就換行
					System.out.println();
				}
				firstDateOfMonth = firstDateOfMonth.plusDays(1);// currentDay+1繼續下一次循環，直到while迴圈結束

			}

			System.out.println();
		}

	}

}
