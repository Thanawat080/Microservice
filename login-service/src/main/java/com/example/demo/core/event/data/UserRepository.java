package com.example.demo.core.event.data;

import com.example.demo.core.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsernameAndPassword(String username, String password);

}
