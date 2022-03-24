package com.herlikhoury.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.services.userServ;

@RestController //necessário para a classer ser um recurso Rest
@RequestMapping(value="/users")//end point

public class userResources {
	
	@Autowired
	private userServ service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<user>> findAll(){

	List<user> lista= service.findAll();
	
	return ResponseEntity.ok().body(lista);
		
	}

}
