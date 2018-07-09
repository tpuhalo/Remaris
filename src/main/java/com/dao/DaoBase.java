package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.gson.JsonObject;

public interface DaoBase {

	
	List<JsonObject> findAll();

	void save(JsonObject gForm);


}
