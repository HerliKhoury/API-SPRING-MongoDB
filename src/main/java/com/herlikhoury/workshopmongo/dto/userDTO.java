package com.herlikhoury.workshopmongo.dto;

import java.io.Serializable;

import com.herlikhoury.workshopmongo.domain.user;

public class userDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	public userDTO() {
	
	}
	
	public userDTO(user objeto) {
		id = objeto.getId();
		name = objeto.getName();
		email = objeto.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
