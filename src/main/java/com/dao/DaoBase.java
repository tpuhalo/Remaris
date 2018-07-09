package com.dao;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Repository;

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

	void setSubmitTime(Time time);
	
	boolean getSubmitTime();
	
}
