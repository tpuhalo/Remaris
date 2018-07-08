package com.zadatak.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zadatak.dao.DaoBase;

public abstract class DaoClass<PK extends Serializable, T> implements DaoBase<PK, T> {

	private final Class<T> persistentClass;

	public DaoClass(Class<T> entityClass) {
		this.persistentClass = entityClass;
	}
	
	@Override
	public Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> objects = null;
		objects = getSession().createQuery("from " + persistentClass.getName()).list();
		return objects;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}
	
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}


}
