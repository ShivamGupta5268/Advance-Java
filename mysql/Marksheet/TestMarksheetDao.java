package com.mysql.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetDao {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testGetByRollNo();
		 testGetMeritList();
		// testSearchMarksheetList();

	}

	private static void testSearchMarksheetList() throws Exception {

		MarksheetDao dao = new MarksheetDao();

		List list = dao.searchMarksheetList();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean1 = new MarksheetBean();
			it.next();
			System.out.println(bean1.getId());
			System.out.println(bean1.getRollNo());
			System.out.print(bean1.getFname());
			System.out.println(bean1.getLname());
		}

	}

	private static void testGetMeritList() throws Exception {

		MarksheetDao dao = new MarksheetDao();

		List list = dao.getMeritList();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {

			MarksheetBean bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	

	}

	private static void testGetByRollNo() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo("111");

		MarksheetDao dao = new MarksheetDao();
		dao.getByRollNo(bean);
	}

	private static void testDelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("110");

		MarksheetDao dao = new MarksheetDao();
		dao.delete(bean);
		System.out.println("Deleted");
	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(3);
		bean.setFname("Rama");
		bean.setPhysics(99);

		MarksheetDao dao = new MarksheetDao();

		dao.update(bean);
		System.out.println("Updated");

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(nextPk());
		bean.setRollNo("RAYS101");
		bean.setFname("Shyam");
		bean.setLname("gupta");
		bean.setPhysics(58);
		bean.setChemistry(75);
		bean.setMaths(85);

		MarksheetDao dao = new MarksheetDao();

		dao.add(bean);
		System.out.println("Inserted");

	}

	public static int nextPk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

}
