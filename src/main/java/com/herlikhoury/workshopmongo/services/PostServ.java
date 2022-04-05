package com.herlikhoury.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlikhoury.workshopmongo.domain.Post;
import com.herlikhoury.workshopmongo.repository.PostRepository;
import com.herlikhoury.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServ {
	
	@Autowired
	private PostRepository repo;
	

	public Post findById(String id) {
	    Optional<Post> user = repo.findById(id);
	    return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle (String text){
		return repo.findByTitleContaining(text);
	}
	
	
}
