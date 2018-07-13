package com.dao;

import java.util.List;

import com.domain.Content;

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

	List<Content> findAll();

	/**
	 * Class for saving object in database.
	 * 
	 * @param String
	 */

	void save(Content gForm);

	/**
	 * Class for getting last updated time for table where we store json.
	 * 
	 * @return String
	 */
	String getSubmitTime();

}
