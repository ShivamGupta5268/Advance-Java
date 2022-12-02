package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class TestPreparedStatement {

	public static void main(String[] args) throws Exception {

		// 	testGetById(3);
			testAdd();
		//  testUpdate();
		//  testDelete(9);

	}

	public static void testGetById(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			// System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getInt(4));
		}
		rs.close();
		ps.close();
		conn.close();
	}

	public static void testAdd() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Insert Into Employee Values(?,?,?,?,?)");

		int id = 10;
		String name = "Nilkamal";
		String lname = "Gupta";
		int salary = 36000;
		int Dept_id = 4;
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, lname);
		ps.setInt(4, salary);
		ps.setInt(5, Dept_id);

		int i = ps.executeUpdate();

		System.out.println(i + " Inserted");

		ps.close();
		conn.close();
	}

	public static void testUpdate() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Update Employee Set fname = ?,lname = ? where id = 2");

		String fname = "Lakhan";
		String lname = "Mishra";

		ps.setString(1, fname);
		ps.setString(2, lname);

		int i = ps.executeUpdate();

		System.out.println(i + " Updated");

		ps.close();
		conn.close();
	}

	public static void testDelete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Delete from employee where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println(i + " deleted");
		
		ps.close();
		conn.close();

	}

}
