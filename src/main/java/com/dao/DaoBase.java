package com.dao;

import java.util.List;

import com.google.gson.JsonObject;

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
	 * @return List<JsonObject>
	 */
	
	List<JsonObject> findAll();

	/**
	 * Class for saving object in database.
	 * Object must be type JsonObject.
	 * 
	 * @param JsonObject
	 */
	
	void save(JsonObject gForm);
	
	String getSubmitTime();
	
}
