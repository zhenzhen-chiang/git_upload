package com.cathaybk.practice.nt50348.b;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HRMain {

	public static void main(String[] args) {
		StringBuilder payInfo = new StringBuilder();

		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
		for (Employee employee : employeeList) {
			employee.printInfo();// 第三題
			payInfo.append(employee.getName()).append(',');
			if (employee instanceof Sales) {
				payInfo.append(((Sales) employee).getPayment()).append('\n');
			} else if (employee instanceof Supervisor) {
				payInfo.append(((Supervisor) employee).getPayment()).append('\n');
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\output.csv"))) {

			bw.write("\ufeff");

			String payInfo1 = payInfo.toString();

			bw.write(payInfo1);


			bw.flush();

		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}
}
