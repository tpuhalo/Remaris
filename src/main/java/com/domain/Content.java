package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "rema")
@Table(name = "content")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "json")
	private String json;

	public Content() {
	}

	public Content(Long id, String name) {
		this.id = id;
		this.json = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return json;
	}

	public void setName(String name) {
		this.json = name;
	}

	@Override
	public String toString() {
		return "Json [id=" + id + ", name=" + json + "]";
	}

}
