package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class TestUpdateDeleteGetById {
	
	public static void main(String[] args) throws Exception {
		
		//testSelect();
		//testUpdate();
		//testDelete();
		testGetById();
	}

	public static void testUpdate() throws Exception{
	
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update employee set fname = 'Aniketram' where id = 2");
		
		System.out.println(i + " updated");
		stmt.close();
		conn.close();		
	}
	
	public static void testDelete() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from employee where id = 6");
		
		System.out.println(i + " Deleted");
		stmt.close();
		conn.close();		
	}
	
	public static void testGetById() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from employee where id = 4");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+ rs.getString(2));
		System.out.print("\t"+ rs.getString(3));
		System.out.print("\t"+ rs.getInt(4));
		
		}
		rs.close();
		stmt.close();
		conn.close();
	
	}
}
