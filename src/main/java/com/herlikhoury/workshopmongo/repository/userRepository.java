package com.herlikhoury.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.herlikhoury.workshopmongo.domain.user;

@Repository
public interface userRepository extends MongoRepository<user, String>{

}
