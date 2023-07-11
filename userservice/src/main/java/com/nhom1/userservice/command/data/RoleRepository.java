package com.nhom1.userservice.command.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository  extends MongoRepository<Role, String> {

}
