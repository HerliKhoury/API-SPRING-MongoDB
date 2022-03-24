package com.herlikhoury.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.repository.userRepository;

@Service
public class userServ {
	
	@Autowired
	private userRepository repo;
	
	public List<user> findAll(){
		return repo.findAll();
	}

}
