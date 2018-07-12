package com.daoimpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dao.DaoBase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class DaoClass implements DaoBase {

	String getTimeUpdated = "SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA = 'rema' AND TABLE_NAME = 'content'";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/rema";
	static final String USER = "user";
	static final String PASS = "userPassword";

	Connection conn = null;
	Statement stmt = null;

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> findAll() {
		List<String> objects = null;
		objects = getSession().createQuery("from content").list();
		return objects;
	}

	@Override
	public void save(String entity) {
		getSession().save(entity);
	}

	@Override
	public String getSubmitTime() {
		ResultSet rs = null;
		String time = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(getTimeUpdated);
			while (rs.next()) {
				time = rs.getString("UPDATE_TIME");
			}
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;

	}

}
