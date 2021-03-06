package com.herlikhoury.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.dto.userDTO;
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
	
	public user insert(user objeto) {
		return repo.insert(objeto);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public user update(user obj) {
		user newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(user newObj, user obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public user fromDTO(userDTO objetoDTO) {
		return new user(objetoDTO.getId(), objetoDTO.getName(), objetoDTO.getEmail());
	}

}
