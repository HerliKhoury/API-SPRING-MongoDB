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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)//Adiciona a parte de busca por id no request como em: http://localhost:8080/users/62422d7a2cde5e2d4e90658d
	public ResponseEntity<userDTO> findById(@PathVariable String id){//Pra saber que estamos pegando a id da URL
	user object = service.findById(id);
	return ResponseEntity.ok().body(new userDTO(object));
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody userDTO objetoDTO){//para que o end point aceite o objeto
		user objeto = service.fromDTO(objetoDTO);
		objeto = service.insert(objeto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();//Pega o endereço do objeto inserido

		return ResponseEntity.created(uri).build();//Cabeçalho com a URL do novo recurso criado
		
	}

}
