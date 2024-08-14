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
import java.util.TreeMap;

public class Cars {

	public static void main(String[] args) throws Exception {
		String inputFilePath = "C:\\Users\\Admin\\Desktop\\Java評量_第6題cars.csv";
		String outputFilePath = "C:\\Users\\Admin\\Desktop\\cars2.csv";
		String headerLine = "";
		List<Map<String, String>> carList = new ArrayList<>(); // 創建一個用來儲存汽車資料的 List，每個元素是一個 Map
		// 讀取 CSV 文件
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
			headerLine = br.readLine(); // 讀取表頭，不做任何處理//readLine是讀取第一行
			String line;
			while ((line = br.readLine()) != null) { // 逐行讀取CSV文件
				String[] values = line.split(","); // 將每行的資料按逗號分割
//				if (values.length == 4) {// 確保一定有四筆才會放入，這個可以不加
				Map<String, String> carMap = new HashMap<>();
				carMap.put("Manufacturer", values[0].trim());
				carMap.put("TYPE", values[1].trim());
				carMap.put("Min.PRICE", values[2].trim());
				carMap.put("Price", values[3].trim());
				carList.add(carMap); // 把這個 Map 放入 List 中
//	                    System.out.println(carList);
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

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));) {

			bw.write(headerLine);// 可以把headerLine
			bw.newLine();
			for (Map<String, String> car : carList) {
				StringBuilder carInfo = new StringBuilder();
				carInfo.append(car.get("Manufacturer")).append(',').append(car.get("TYPE")).append(',')
						.append(car.get("Min.PRICE")).append(',').append(car.get("Price"));
				String carInfo1 = carInfo.toString();
				bw.write(carInfo1);// sb
				bw.newLine();
			}
		} catch (Exception e) {
			throw e;
		}

		Map<String, List<Map<String, String>>> groupedCars = new TreeMap<>();// 原hash改tree

		for (Map<String, String> car : carList) {
			String manufacturer = car.get("Manufacturer");
			groupedCars.putIfAbsent(manufacturer, new ArrayList<>());
			groupedCars.get(manufacturer).add(car);
		}

		// 打印分组后的數據，計算小計和總計
		BigDecimal totalMinPrice = BigDecimal.ZERO;// 合計歸零
		BigDecimal totalPrice = BigDecimal.ZERO;
		System.out.printf("%-15s%-10s%10s%10s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
		for (String manufacturer : groupedCars.keySet()) {
			BigDecimal manufacturerMinPriceTotal = BigDecimal.ZERO;// 小計歸零
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
