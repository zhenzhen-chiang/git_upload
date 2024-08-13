package com.cathaybk.javaedu.lesson3.practice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class QueryByPK {

	public static void main(String[] args) {
        String connUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
        ResultSet rs = null;
//從prepareStatement複製過來
        try (Connection conn = DriverManager.getConnection(connUrl, "student", "student123456");
                PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?");) {

            pstmt.setString(1, "Toyota");//定義我要找的值
            pstmt.setString(2, "R8");

            //ResultSet物件儲存查詢結果
             rs = pstmt.executeQuery();

            Map<String, String> map = new HashMap<>();//用map存所以要先new一個
            while (rs.next()) {//對rs做像是迭代的事
                map.put("MANUFACTURER", rs.getString("MANUFACTURER"));//在map欄位put進從rs get到的值
                map.put("TYPE", rs.getString("TYPE"));
                map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
                map.put("PRICE", rs.getString("PRICE"));
            }

            StringBuilder sb = new StringBuilder();
            if (!map.isEmpty()) {
                BigDecimal price = new BigDecimal(map.get("PRICE"));
                sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，售價：$").append(price)
                        .append("，底價：$").append(map.get("MIN_PRICE"));
            } else {
                sb.append("查無結果");
            }
            System.out.println(sb.toString());//sb是一個物件所以要用toString

//            rs.close();//偷懶的用法
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				}catch (Exception e2) {
					 e2.printStackTrace();
				}
			
			}
}
    }

