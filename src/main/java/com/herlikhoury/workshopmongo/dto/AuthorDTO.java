package com.herlikhoury.workshopmongo.dto;

import com.herlikhoury.workshopmongo.domain.user;

public class AuthorDTO {
	private String id;
	private String name;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(user objeto) {
		id = objeto.getId();
		name = objeto.getName();
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

}
