package com.herlikhoury.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herlikhoury.workshopmongo.domain.Post;
import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.dto.userDTO;
import com.herlikhoury.workshopmongo.services.PostServ;

@RestController //necessário para a classer ser um recurso Rest
@RequestMapping(value="/posts")//end point

public class PostResources {
	
	@Autowired
	private PostServ service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)//Adiciona a parte de busca por id no request como em: http://localhost:8080/users/62422d7a2cde5e2d4e90658d
	public ResponseEntity<Post> findById(@PathVariable String id){//Pra saber que estamos pegando a id da URL
	Post object = service.findById(id);
	return ResponseEntity.ok().body(object);
		
	}
	
}
