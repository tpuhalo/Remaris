package com.dao;

import java.util.List;

import com.google.gson.JsonObject;

public interface DaoBase {

	List<JsonObject> findAll();

	void save(JsonObject gForm);


}
