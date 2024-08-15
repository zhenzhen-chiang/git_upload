package com.cathaybk.practice.nt50348.b;

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
import java.util.TreeMap;

public class Database {
	private static final String SELECT_CARS_SQL = "select * from  STUDENT.CARS";

	private static final String SELECT_CARS_SQL1 = "select * from  STUDENT.CARS WHERE MANUFACTURER=? AND TYPE=?";

	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	private static final String UPDATE_STRING = "update STUDENT.CARS set MIN_PRICE =?,PRICE=? WHERE MANUFACTURER=? AND TYPE=?";

	private static final String DELETE_STRING = "delete from  STUDENT.CARS  WHERE MANUFACTURER=? AND TYPE=?";

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String USER_PASSWORD = "student123456";

	// SQL語法跟連線語法(user跟pw)都要放外面

	public static void main(String[] args) {
		ResultSet rs = null;

		List<Map<String, String>> carList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, USER_PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);) {
			conn.setAutoCommit(false);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));

				carList.add(map);
				System.out.println(map);
			}

		} catch (SQLException e) {// SQLException
			e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("請選擇以下指令輸入:select、insert、update、delete");
			String operation = scanner.next();
			try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, USER_PASSWORD);) {
				switch (operation) {
				case "select":
					try (Scanner scanner2 = new Scanner(System.in);) {
						System.out.println("請輸入製造商:");
						String manufacturer = scanner2.nextLine();
						System.out.println("請輸入類型:");
						String type = scanner2.nextLine();
						System.out.println("請輸入底價:");
						int minprice = scanner2.nextInt();
						System.out.println("請輸入售價:");
						int price = scanner2.nextInt();
					query(manufacturer,type);
					}break;
				case "insert":
					insert(conn);
					break;
				case "update":
					boolean success = false;
					while (!success) {
						try (Scanner scanner1 = new Scanner(System.in);) {
							System.out.println("請輸入製造商:");
							String manufacturer = scanner1.nextLine();
							System.out.println("請輸入類型:");
							String type = scanner1.nextLine();
							System.out.println("請輸入新底價:");
							int minprice = scanner1.nextInt();
							System.out.println("請輸入新售價:");
							int price = scanner1.nextInt();
							

							Map<String, String> updateMap = new TreeMap<>();
							updateMap.put("MANUFACTURER", manufacturer);
							updateMap.put("TYPE", type);
							updateMap.put("MIN_PRICE", Integer.toString(minprice));
							updateMap.put("PRICE", Integer.toString(price));// int轉String
							success=update(updateMap);
						}
					}
					break;

				case "delete":
					delete(conn);
					break;
				default:
					System.out.println("重新選擇");
				}
			} catch (SQLException e) { // 有catch要做事
				e.printStackTrace();
			}
		}
	}

	private static void query(String manufacturer, String type)throws SQLException { 
		
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, USER_PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL1);) {
			ResultSet rs = null;
		
			while (rs.next()) {
	
				System.out.println("製造商: " + rs.getString("MANUFACTURER") + ", 型號: " + rs.getString("TYPE") + ", 底價: "
						+ rs.getInt("MIN_PRICE") + ", 售價: " + rs.getInt("PRICE"));
			}
			rs.close();
		} catch (Exception e) {

		} finally {

		}
	}


	private static void insert(Connection conn) throws SQLException {
		try (Scanner scanner = new Scanner(System.in);) {
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

	private static boolean update(Map<String, String> updateMap) throws SQLException {
		
			try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, USER_PASSWORD);
					PreparedStatement pstmt = conn.prepareStatement(UPDATE_STRING);) {
				conn.setAutoCommit(false);
				pstmt.setInt(1, Integer.parseInt(updateMap.get("MIN_PRICE")));// String轉int
				pstmt.setInt(2, Integer.parseInt(updateMap.get("PRICE")));
				pstmt.setString(3, updateMap.get("MANUFACTURER").toString());
				pstmt.setString(4, updateMap.get("TYPE").toString());
				pstmt.executeUpdate();
				conn.commit();
				if (pstmt.executeUpdate() == 0) {
					return false;
				} else {
					
					System.out.println("更新成功，已更新:" + pstmt.executeUpdate() + "筆");
					
					return true;
				}
			} catch (SQLException sqle) {
				System.out.println("更新失敗，原因：" + sqle.getMessage());
			}
			try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, USER_PASSWORD);) {
				conn.setAutoCommit(false);
				conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("rollback失敗，原因：" + sqle.getMessage());
			}
			return false;
		}
	

	private static void delete(Connection conn) {

		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.nextLine();
			System.out.println("請輸入類型:");
			String type = scanner.nextLine();
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_STRING);) {
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
//	private static void update1(Connection conn) throws SQLException {
//		String updateString = "UPDATE STUDENT.CARS SET MIN_PRICE =? WHERE MANUFACTURER=? AND TYPE=?";
//		String updateString1 = "UPDATE STUDENT.CARS SET PRICE=? WHERE MANUFACTURER=? AND TYPE=?";
//		String updateString2 = "UPDATE STUDENT.CARS SET MIN_PRICE =?,PRICE=? WHERE MANUFACTURER=? AND TYPE=?";
//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.println("請輸入製造商:");
//			String manufacturer = scanner.nextLine();
//			System.out.println("請輸入類型:");
//			String type = scanner.nextLine();
//			System.out.println("請輸入新底價:");
//			BigDecimal minprice = scanner.nextBigDecimal();
//			System.out.println("請輸入新售價:");
//			BigDecimal price = scanner.nextBigDecimal();
//			try (PreparedStatement pstmt = conn.prepareStatement(updateString)) {
//				conn.setAutoCommit(false);
//				pstmt.setBigDecimal(1, minprice);
//				pstmt.setBigDecimal(2, price);
//				pstmt.setString(3, manufacturer);
//				pstmt.setString(4, type);
//				pstmt.executeUpdate();
//				conn.commit();
//				System.out.println("更新成功");
//			} catch (Exception e) {
//				System.out.println("更新失敗，原因：" + e.getMessage());
//				try {
//					conn.rollback();
//				} catch (SQLException sqle) {
//					sqle.printStackTrace();
//					System.out.println("rollback失敗，原因：" + sqle.getMessage());
//				}
//			}
//
//		} catch (Exception scan) {
//			scan.printStackTrace();
//		}
//	}

}
