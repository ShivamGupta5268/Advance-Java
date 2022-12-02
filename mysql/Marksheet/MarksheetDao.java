package com.mysql.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetDao {

	public static void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("Insert into marksheet values(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());

		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public static void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Update marksheet Set id=?,rollno=?,firstname=?,lastname=?,physics=?,chemistry=?,maths=? where id=?");

		ps.setInt(1, bean.getId());
		ps.setString(2,bean.getRollNo());
		ps.setString(3, bean.getFname());
		ps.setString(4,bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6,bean.getChemistry());
		ps.setInt(7,bean.getMaths());
		ps.setInt(8, bean.getId());


		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public static void delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Delete from Marksheet where rollNo = ?");

		ps.setString(1, bean.getRollNo());

		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public static void getByRollNo(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Select * from Marksheet where rollNo = ? ");

		ps.setString(1, bean.getRollNo());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.print("\t" + rs.getInt(6));
			System.out.println("\t" + rs.getInt(7));
		}
	}

	public List<MarksheetBean> getMeritList() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.resourceBundle.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement(
				"Select *,(physics + chemistry + maths) as Marks from Marksheet Order By Marks Desc Limit 10");
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			list.add(bean);

		}

		return list;
	}

	public List<MarksheetBean> searchMarksheetList() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Select * from Marksheet ");

		ResultSet rs = ps.executeQuery();

		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));

			list.add(bean);
		}
		return list;

	}

}
