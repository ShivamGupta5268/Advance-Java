	package com.mysql.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StoredProceadureCollableStatement {
	
	public static void main(String[] args) throws Exception {
		
		testCollable();
	}

	private static void testCollable() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
		
		CallableStatement col = conn.prepareCall("{call empCount(?)}");
		
		col.registerOutParameter(1, Types.INTEGER);	
		
		col.execute();
		
		System.out.println(col.getInt(1));
		
	}

	

	

}
