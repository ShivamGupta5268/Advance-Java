package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AutoNextPrimaryKey {


	public static void main(String[] args) throws Exception{
		
		testAdd();		
	}
	public static int nextPk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement("select max(id) from monu");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	
	public static void testAdd() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Insert Into monu Values(?,?)");

		// int pk;
		String name = "Nilkamal";
		
		ps.setInt(1, nextPk());
		ps.setString(2, name);

		int i = ps.executeUpdate();

		System.out.println(i + " Inserted");

		ps.close();
		conn.close();
	}
	
	

}
