package com.herlikhoury.workshopmongo.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.repository.userRepository;


@Configuration
public class instanciacao implements CommandLineRunner {

	@Autowired
	private userRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		user gandalf = new user(null, "Gandalf the Grey", "gray@wizard.com");
		user thorin = new user(null, "Thorin Oaken Shield", "king@mountain.com");
		user dain = new user(null, "Dain Iron Foot", "LordBoar@IronHills.com");
		
		userRepository.saveAll(Arrays.asList(gandalf, thorin, dain));
		
		
	}
	
	

}
