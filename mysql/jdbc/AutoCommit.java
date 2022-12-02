package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AutoCommit {

	public static void main(String[] args) throws Exception {
		
		    testAutoCommit();		
		//  withoutAutoCommit();
	}

	public static void testAutoCommit() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");

		conn.setAutoCommit(false);
		
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("Insert into employee values(14,'shivam','gupta',30700,4)");
		stmt.executeUpdate("Insert into employee values(15,'shivam','gupta',30700,4)");
		stmt.executeUpdate("Insert into employee values(14,'shivam','gupta',30700,4)");
		stmt.executeUpdate("Insert into employee values(16,'shivam','gupta',30700,4)");
		
		conn.commit();
		System.out.println("Not Inserted");		
	}

	public static void withoutAestAutoCommit() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
		
		//conn.setAutoCommit(false);
		
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("Insert into employee values(11,'shivam','gupta',30700,4)");		
		stmt.executeUpdate("insert into employee values(12,'lakhan', 'pandey', 20700,5)");		
		stmt.executeUpdate("insert into employee values(11,'lakhan', 'pandey', 20700,5)");		
		stmt.executeUpdate("insert into employee values(13,'lakhan', 'pandey', 20700,5)");
		
		//conn.commit();
		
		System.out.println("Inserted");
		
		
		
	}
	
	
	
}
