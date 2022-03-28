package com.herlikhoury.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.dto.userDTO;
import com.herlikhoury.workshopmongo.services.userServ;

@RestController //necessário para a classer ser um recurso Rest
@RequestMapping(value="/users")//end point

public class userResources {
	
	@Autowired
	private userServ service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<userDTO>> findAll(){

	List<user> lista= service.findAll();
	List<userDTO> listaDTO = lista.stream().map(x -> new userDTO(x)).collect(Collectors.toList());//Cria a lista de DTOs
	return ResponseEntity.ok().body(listaDTO);
		
	}

}
