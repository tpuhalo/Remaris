package com.daoimpl;

import java.sql.Time;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dao.DaoBase;
import com.google.gson.JsonObject;

@Repository
public class DaoClass implements DaoBase {

	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<JsonObject> findAll() {
		List<JsonObject> objects = null;
		objects = getSession().createQuery("from content").list();
		return objects;
	}
	
	@Override
	public void save(JsonObject entity) {
		getSession().save(entity);
	}

	@Override
	public void setSubmitTime(Time time) {
		getSession().save(entity);
	}

	@Override
	public boolean getSubmitTime() {

		return false;
	}

}
