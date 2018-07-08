package com.zadatak.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;


public interface DaoBase<PK extends Serializable, T> {
	
	public Criteria createEntityCriteria();
	
	List<T> findAll();
	
	public T getByKey(PK key);
	
	public void delete(T entity);

	void save(T entity);

	void update(T entity);

}
