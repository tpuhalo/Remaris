package com.dao;

import java.util.List;

/**
 * Interface for creating classes in DAO implementation.
 * 
 * 
 * @author Tihomir Puhalo
 *
 */
public interface DaoBase {
	
	
	/**
	 * Class for fetching all data in database.
	 * 
	 * @return List<String>
	 */
	
	List<String> findAll();

	/**
	 * Class for saving object in database. 
	 * @param String
	 */
	
	void save(String gForm);
	
	String getSubmitTime();
	
}
