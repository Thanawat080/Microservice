package com.example.demo.query.rest;

import com.example.demo.core.UserEntity;
import com.example.demo.query.FindByUsernameAndPassword;
import com.example.demo.query.FindUserByIdQuery;
import com.example.demo.query.FindUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserQueryController {
    @Autowired
    QueryGateway queryGateway;
    @GetMapping
    public List<UserRestModel> getUser(){
        FindUserQuery findUserQuery = new FindUserQuery();
        List<UserRestModel> users = queryGateway.query(findUserQuery, ResponseTypes.multipleInstancesOf(UserRestModel.class)).join();
        return users;
    }
    @GetMapping(value = "/{id}")
    public UserEntity getUserById(@PathVariable String id){
        FindUserByIdQuery findUserByIdQuery = new FindUserByIdQuery(id);
        UserEntity usersbyId = queryGateway.query(findUserByIdQuery, ResponseTypes.instanceOf(UserEntity.class)).join();
        return usersbyId;
    }
    @GetMapping(value = "/{username}/{password}")
    public UserRestModel getUserByUnameAndP(@PathVariable String username, @PathVariable String password){
        FindByUsernameAndPassword findByUsernameAndPassword = new FindByUsernameAndPassword(username, password);
        UserRestModel userbyunameAndPass = queryGateway.query(findByUsernameAndPassword, ResponseTypes.instanceOf(UserRestModel.class)).join();
        return userbyunameAndPass;
    }
}
