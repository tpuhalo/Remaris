package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DaoBase;
import com.domain.FormInputtedDomain;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
@Transactional
public class MainService implements ServiceBase {

	String url = "http://jsonplaceholder.typicode.com/users";

	@Autowired
	DaoBase daoBase;
	
	public String checkFormInputted(FormInputtedDomain form) throws IOException {
		String error = "";

		JsonElement onlineForm = getOnlineForm(form.getEmail());
		JsonObject gForm = objectToJson(form);
		if (onlineForm.toString().isEmpty()) {
			daoBase.save(gForm);
			error = "Your form was saved in database.";
		} else {
			JsonObject obj = onlineForm.getAsJsonObject();
			daoBase.save(obj);
			error = "Online form was saved in database.";
		}


		return error;
	}

	private JsonElement getOnlineForm(String email) throws IOException {
		URL emailURL;
		URLConnection request = null;

		try {
			emailURL = new URL(url + "?email=" + email);
			request = emailURL.openConnection();
			request.connect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		
		

		return root;
	}

	public JsonObject objectToJson(FormInputtedDomain object) {
		JsonObject gForm = new JsonObject();
		gForm.addProperty("name", object.getName());
		gForm.addProperty("surname", object.getName());
		gForm.addProperty("email", object.getName());
		return gForm;
	}
}
