package com.herlikhoury.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herlikhoury.workshopmongo.domain.user;

@RestController //necessário para a classer ser um recurso Rest
@RequestMapping(value="/users")//end point

public class userResources {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<user>> findAll(){
		
		user gandalf = new user("1", "Gandalf the Gray", "gray@wizard.com");
		user thorin = new user("2", "Thorin Oaken Shield", "king@mountain.com");
		
		List<user> lista= new ArrayList<>();
		lista.addAll(Arrays.asList(gandalf, thorin));
		
		return ResponseEntity.ok().body(lista);
		
	}

}
