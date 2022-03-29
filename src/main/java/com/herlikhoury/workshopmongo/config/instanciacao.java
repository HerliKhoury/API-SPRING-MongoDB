package com.herlikhoury.workshopmongo.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.herlikhoury.workshopmongo.domain.Post;
import com.herlikhoury.workshopmongo.domain.user;
import com.herlikhoury.workshopmongo.repository.PostRepository;
import com.herlikhoury.workshopmongo.repository.userRepository;


@Configuration
public class instanciacao implements CommandLineRunner {

	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		user gandalf = new user(null, "Gandalf the Grey", "gray@wizard.com");
		user thorin = new user(null, "Thorin Oaken Shield", "king@mountain.com");
		user dain = new user(null, "Dain Iron Foot", "LordBoar@IronHills.com");
		user theoden = new user(null, "Theoden of Rohan", "WhereWas@Gondor.com");
		
		Post post1 = new Post(
				null, 
				sdf.parse("15/06/1933"), 
				"Gondor calls for aid!", 
				"The armies of Mordor have surrounded Minas Tirith! Free folks of Middle Earth I summon you!",
				gandalf
		);
		
		Post post2 = new Post(
				null, 
				sdf.parse("15/06/1933"), 
				"Gondor can handle her own problems!", 
				"Where was Gondor when the West Fold fell?",
				theoden
		);
		
		userRepository.saveAll(Arrays.asList(gandalf, thorin, dain, theoden));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}
	
	

}
