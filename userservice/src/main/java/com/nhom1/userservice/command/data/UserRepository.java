package com.nhom1.userservice.command.data;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository <User, String> {
	User findFirstByEmail(String email);

}
