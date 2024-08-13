package com.cathaybk.pratice.nt50348.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Database {

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
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}
}
