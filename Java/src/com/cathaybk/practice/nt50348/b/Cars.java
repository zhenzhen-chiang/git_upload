package com.cathaybk.practice.nt50348.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\Admin\\Desktop\\Java評量_第6題cars.csv";
		String outputFilePath = "C:\\Users\\Admin\\Desktop\\cars2.csv";

		List<Map<String, String>> carList = new ArrayList<>(); // 創建一個用來儲存汽車資料的 List，每個元素是一個 Map

		// 讀取 CSV 文件
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

			String headerLine = br.readLine(); // 讀取表頭，不做任何處理
			String line;
			while ((line = br.readLine()) != null) { // 逐行讀取CSV文件
				String[] values = line.split(","); // 將每行的資料按逗號分割
				if (values.length == 4) {
					Map<String, String> carMap = new HashMap<>();
					carMap.put("Manufacturer", values[0].trim());
					carMap.put("TYPE", values[1].trim());
					carMap.put("Min.PRICE", values[2].trim());
					carMap.put("Price", values[3].trim());
					carList.add(carMap); // 把這個 Map 放入 List 中
//	                    System.out.println(carList);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(carList, new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				BigDecimal price1 = new BigDecimal(o1.get("Price"));
				BigDecimal price2 = new BigDecimal(o2.get("Price"));
				return price2.compareTo(price1);
			}
		});

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
			bw.write("Manufacturer,TYPE,Min.PRICE,Price");
			bw.newLine();
			for (Map<String, String> car : carList) {
				bw.write(car.get("Manufacturer") + "," + car.get("TYPE") + "," + car.get("Min.PRICE") + ","
						+ car.get("Price"));
				bw.newLine();
			}
		} catch (Exception e) {

		}
		Map<String, List<Map<String, String>>> groupedCars = new HashMap<>();

		for (Map<String, String> car : carList) {
			String manufacturer = car.get("Manufacturer");
			groupedCars.putIfAbsent(manufacturer, new ArrayList<>());
			groupedCars.get(manufacturer).add(car);
		}

		// 打印分组后的數據，計算小計和總計
		BigDecimal totalMinPrice = BigDecimal.ZERO;
		BigDecimal totalPrice = BigDecimal.ZERO;
		System.out.printf("%-15s%-10s%10s%10s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
		for (String manufacturer : groupedCars.keySet()) {
			BigDecimal manufacturerMinPriceTotal = BigDecimal.ZERO;
			BigDecimal manufacturerPriceTotal = BigDecimal.ZERO;

			for (Map<String, String> car : groupedCars.get(manufacturer)) {
				BigDecimal minPrice = new BigDecimal(car.get("Min.PRICE"));
				BigDecimal price = new BigDecimal(car.get("Price"));

				manufacturerMinPriceTotal = manufacturerMinPriceTotal.add(minPrice);
				manufacturerPriceTotal = manufacturerPriceTotal.add(price);
				System.out.printf("%-15s%-10s%10s%10s\n", manufacturer, car.get("TYPE"), car.get("Min.PRICE"),
						car.get("Price"));
			}

			System.out.printf("%-15s%-11s%8s%10s\n", "小計：", "    ", manufacturerMinPriceTotal, manufacturerPriceTotal);
			totalMinPrice = totalMinPrice.add(manufacturerMinPriceTotal);
			totalPrice = totalPrice.add(manufacturerPriceTotal);
		}

		// 打印總和
		System.out.printf("%-15s%-10s%9s%10s\n", "合計：", "    ", totalMinPrice, totalPrice);
	}
}
