package com.cathaybk.javaedu.lesson3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {

    public static void main(String[] args) {
        String connUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
        ResultSet rs = null; 
        try (Connection conn = DriverManager.getConnection(connUrl, "student", "student123456"
        		+ "");
                PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.MEMBER where ID = ? and PWD = ?");
                ) {

            pstmt.setString(1, "hello");
            pstmt.setString(2, "hello");

            // ResultSet物件儲存查詢結果
             rs = pstmt.executeQuery();

            // 使用StringBuilder做字串串接
            StringBuilder sb = new StringBuilder();
            sb.append("查詢結果：");
            while (rs.next()) {
                // "{ ID： " + rs.getString("ID") + "   PWD：..."
                sb.append("{ ID： ").append(rs.getString("ID")).append("   PWD：").append(rs.getString(2)).append("   NAME：")
                        .append(rs.getString("NAME")).append(" }");
                System.out.println(sb.toString());
                sb.setLength(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        


