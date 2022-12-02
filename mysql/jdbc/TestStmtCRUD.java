package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStmtCRUD {
	
	public static void main(String[] args) throws Exception {
		
		//testSelect();
		  testADD();
	}

	private static void testADD() throws Exception{
	
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into employee values(6,'Ganesh','Gupta',30000, 4)");
		
		System.out.print(i + " inserted");
		
		stmt.close();
		conn.close();
		
	
	}	

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employee");
		
	//  ResultSet rs = stmt.executeQuery("select * from employee where id = 1");
	//  we can also findout indivisible rows
	//	ResultSet rs = stmt.executeQuery("select * from employee where id = 2");
		
		while(rs.next()) {
		//	System.out.print(rs.getString(0));
			System.out.print("\t"+ rs.getInt(1));
			System.out.print("\t"+ rs.getString(2));
			System.out.print("\t"+ rs.getString(3));
			System.out.print("\t"+ rs.getInt(4));
			System.out.println("\t"+ rs.getInt(5));		
			
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
