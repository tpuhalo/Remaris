package com.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FormInputtedDomain {

	@Size(max = 20, message = "* Max 20 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String name;

	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String surname;

	@Email
	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FormInputtedDomain [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
	
}
