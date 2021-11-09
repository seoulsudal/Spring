package com.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleJDBCConnerctionTest {

	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "hr";
	private static final String pw = "1234";
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(driver);
		
		try {
			Connection con = DriverManager.getConnection(URL, user, pw);
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
