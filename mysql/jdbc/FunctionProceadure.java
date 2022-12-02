package com.mysql.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionProceadure {

	public static void main(String[] args) throws Exception {
		
		testFunction();		
	}

	public static void testFunction() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
		
		CallableStatement col = conn.prepareCall("{?=Call empCount()}");
		
		col.registerOutParameter(1, Types.INTEGER);
		
		col.execute();
		
		System.out.println(col.getInt(1));
	}
}
