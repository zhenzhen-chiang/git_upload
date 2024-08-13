package com.cathaybk.javaedu.lesson3.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryByManufacturer {

	public static void main(String[] args) {
		String connUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
		ResultSet rs = null;
		List<Map<String, String>> carList = new ArrayList<>();// list裡面裝map
//從prepareStatement複製過來
		try (Connection conn = DriverManager.getConnection(connUrl, "student", "student123456");
				PreparedStatement pstmt = conn
						.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? ");) {

			pstmt.setString(1, "Toyota");// 定義我要找的值
			rs = pstmt.executeQuery();// ResultSet物件儲存查詢結果
			while (rs.next()) {// 對rs做像是迭代的事
				Map<String, String> map = new HashMap<String, String>();
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));// 在map欄位put進從rs get到的值
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));

				carList.add(map);
			} // map是一個一個new進去，所以先把值放進去list裡面

			StringBuilder sb = new StringBuilder();// 在sb中增建欄位放入製造商、型號、TYPE、底價、最低價
			if (!carList.isEmpty()) {

				for (Map<String, String> carMap : carList) {
					BigDecimal price = new BigDecimal(carMap.get("PRICE"));// price變成可運算數值
					BigDecimal price1 = new BigDecimal(carMap.get("MIN_PRICE"));// min_price變成可運算數值
					BigDecimal result = price.subtract(price1);// 兩者相減

					sb.append("製造商：").append(carMap.get("MANUFACTURER")).append("，型號：").append(carMap.get("TYPE"))
							.append("，售價：$").append(price).append("，底價：$").append(price1)
							.append("，售價高於底價：").append(result);//新增相減的欄位

					System.out.println(sb.toString());// sb是一個物件所以要用toString
					sb.setLength(0);
				}

			} else {
				sb.append("查無結果");
			}

//            rs.close();//偷懶的用法
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

}
