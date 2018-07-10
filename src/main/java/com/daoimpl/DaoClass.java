package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dao.DaoBase;

@Repository
public class DaoClass implements DaoBase {

	String getTimeUpdated = "SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'rema' AND TABLE_NAME = 'content'";

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
		return getSession().createQuery(getTimeUpdated).toString();
	}

}
