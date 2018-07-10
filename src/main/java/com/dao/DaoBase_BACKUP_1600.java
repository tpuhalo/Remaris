package com.dao;

import java.sql.Time;
import java.util.List;

import com.google.gson.JsonObject;

/**
 * Interface for creating classes in DAO implementation.
 * 
 * 
 * @author Tihomir Puhalo
 *
 */

<<<<<<< HEAD
=======
public interface DaoBase {
	
	
	/**
	 * Class for fetching all data in database.
	 * 
	 * @return List<JsonObject>
	 */
>>>>>>> 8c1107e33d517694fb40d0be44950185394d6dfa
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
