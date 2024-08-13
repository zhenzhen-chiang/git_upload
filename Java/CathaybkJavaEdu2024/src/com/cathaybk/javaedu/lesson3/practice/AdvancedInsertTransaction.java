package com.cathaybk.javaedu.lesson3.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AdvancedInsertTransaction {
	
	private static final String SELECT_CARS_SQL = "select * from  STUDENT.CARS";

	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	public static void main(String[] args) {
		doInsert();

	}

	public static void doInsert() {
		Connection conn = null;
		String empId = "00000";

		try {
			conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
			Random rand = new Random();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);

			pstmt.setString(1, "CATHAYBK" + empId);
			pstmt.setString(2, empId + 1);
			pstmt.setInt(3, rand.nextInt(1000) + 1);
			pstmt.setInt(4, rand.nextInt(1000) + 2);
			pstmt.executeUpdate();// 第一筆資料加進去

			pstmt.setString(1, "CATHAYBK" + empId);
			pstmt.setString(2, empId + 2);
			pstmt.setInt(3, rand.nextInt(1000) + 1);
			pstmt.setInt(4, rand.nextInt(1000) + 2);
			pstmt.executeUpdate();// 第二筆資料加進去
			conn.commit();
			System.out.println("新增成功");

		} catch (Exception e) {
			System.out.println("新增失敗");
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				System.out.println("rollback 失敗，原因：" + sqle.getMessage());
			}
		}finally {
			doQuery(conn, empId);
		}
	}

	private static void doQuery(Connection conn, String empId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);
			
			ResultSet rs = pstmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append("製造商： ").append(rs.getString("MANUFACTURER")).append("，型號：").append(rs.getString("TYPE"))
						.append("，售價：").append(rs.getString("PRICE")).append("，底價：").append(rs.getString("MIN_PRICE"));
			System.out.println(sb.toString());
			sb.setLength(0);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

//	public static void doQuery() {
//		try(Connection conn = DriverManager.getConnection(CONN_URL,"student","student123456");){
//			PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?");
//			pstmt.setString(1,"CATHAYBK"+empId);
//			ResultSet rs = pstmt.executeQuery();
//			StringBuilder sb = new StringBuilder();
//			 sb.append("查詢結果： ");
//	            while (rs.next()) {
//	                sb.append("製造商： ").append(rs.getString("MANUFACTURER")).append("，型號：").append(rs.getString("TYPE"))
//	                        .append("，售價：").append(rs.getString("PRICE")).append("，底價：").append(rs.getString("MIN_PRICE"));
//	            }
//	            System.out.println(sb.toString());
//	            sb.setLength(0);
//		}
//		
//
//	}
//}
//
//}
