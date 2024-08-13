package com.cathaybk.javaedu.lesson3.practice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.standard.JobMessageFromOperator;

public class Database {
	private static final String SELECT_CARS_SQL = "select * from  STUDENT.CARS";

	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	public static void main(String[] args) {
		ResultSet rs = null;
		Connection conn = null;
		
		List<Map<String, String>> carList = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));

				carList.add(map);
				
			}for (Map<String, String> map : carList) {
				System.out.println(map);
			}
			
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
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("請選擇以下指令輸入:select、insert、update、delete");
			String operation = scanner.next();
			try {
				conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
				switch (operation) {
				case "select":
					query(conn);
					break;
				case "insert":
					insert(conn);
					break;
				case "update":
					update(conn);
					break;
				case "delete":
					delete(conn);
					break;
				default:
					System.out.println("重新選擇");
				}
			} catch (Exception e) {
				
			}
		}
	}

	private static void query(Connection conn) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				System.out.println("製造商: " + rs.getString("MANUFACTURER") + ", 型號: " + rs.getString("TYPE") + ", 底價: "
						+ rs.getInt("MIN_PRICE") + ", 售價: " + rs.getInt("PRICE"));
			}rs.close();
		} catch (Exception e) {
			
		} finally {

		}
	}

	private static void insert(Connection conn) throws SQLException {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.nextLine();
			System.out.println("請輸入類型:");
			String type = scanner.nextLine();
			System.out.println("請輸入底價:");
			BigDecimal minprice = scanner.nextBigDecimal();
			System.out.println("請輸入售價:");
			BigDecimal price = scanner.nextBigDecimal();
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL)) {
				conn.setAutoCommit(false);
				pstmt.setString(1, manufacturer);
				pstmt.setString(2, type);
				pstmt.setBigDecimal(3, minprice);
				pstmt.setBigDecimal(4, price);
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("新增成功");
			} catch (Exception e) {
				System.out.println("新增失敗，原因：" + e.getMessage());
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					System.out.println("rollback失敗，原因：" + sqle.getMessage());
				}
			}

		} catch (Exception scan) {
			scan.printStackTrace();
		}
	}

	private static void update(Connection conn) throws SQLException {
		String updateString = "UPDATE STUDENT.CARS SET MIN_PRICE =?,PRICE=? WHERE MANUFACTURER=? AND TYPE=?";
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.nextLine();
			System.out.println("請輸入類型:");
			String type = scanner.nextLine();
			System.out.println("請輸入新底價:");
			BigDecimal minprice = scanner.nextBigDecimal();
			System.out.println("請輸入新售價:");
			BigDecimal price = scanner.nextBigDecimal();
			try (PreparedStatement pstmt = conn.prepareStatement(updateString)) {
				conn.setAutoCommit(false);
				pstmt.setBigDecimal(1, minprice);
				pstmt.setBigDecimal(2, price);
				pstmt.setString(3, manufacturer);
				pstmt.setString(4, type);
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("更新成功");
			} catch (Exception e) {
				System.out.println("更新失敗，原因：" + e.getMessage());
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					System.out.println("rollback失敗，原因：" + sqle.getMessage());
				}
			}

		} catch (Exception scan) {
			scan.printStackTrace();
		}
	}

	private static void delete(Connection conn) {
		String deleteString = "delete from  STUDENT.CARS  WHERE MANUFACTURER=? AND TYPE=?";
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.nextLine();
			System.out.println("請輸入類型:");
			String type = scanner.nextLine();
			try (PreparedStatement pstmt = conn.prepareStatement(deleteString)) {
				conn.setAutoCommit(false);
				pstmt.setString(1, manufacturer);
				pstmt.setString(2, type);
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("刪除成功");
			} catch (Exception e) {
				System.out.println("刪除失敗，原因：" + e.getMessage());
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					System.out.println("rollback失敗，原因：" + sqle.getMessage());
				}
			}

		}
	}
}