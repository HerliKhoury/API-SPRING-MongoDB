package com.herlikhoury.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.repository.userRepository;
import com.herlikhoury.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class userServ {
	
	@Autowired
	private userRepository repo;
	
	public List<user> findAll(){
		return repo.findAll();
	}
	
	public user findById(String id) {
		Optional<user> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
