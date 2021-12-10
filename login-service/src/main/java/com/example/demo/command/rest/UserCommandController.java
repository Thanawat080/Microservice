package com.example.demo.command.rest;

import com.example.demo.command.CreateUserCommand;

import com.example.demo.command.UpdateUserCommand;
import lombok.Data;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserCommandController {
    private final CommandGateway commandGateway;
    @Autowired
    public UserCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }
    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserRestModel model){
        CreateUserCommand command = CreateUserCommand.builder()
                .id(UUID.randomUUID().toString())
                .f_name(model.getF_name())
                .l_name(model.getL_name())
                .username(model.getUsername())
                .password(model.getPassword())
                .email(model.getEmail())
                .phone_number(model.getPhone_number())
                .usertype(model.getUsertype()).build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            e.printStackTrace();
            result = e.getLocalizedMessage();
        }

        return result;
    }

    @PutMapping("/update/profile")
    public String updateUser(@RequestBody UpdataUserModel updataUserModel){
        UpdateUserCommand command1 = UpdateUserCommand.builder().id(updataUserModel.getId()).f_name(updataUserModel.getF_name()).l_name(updataUserModel.getL_name()).email(updataUserModel.getEmail()).phone_number(updataUserModel.getPhone_number()).build();
        String result1;
        try{
            result1 = commandGateway.sendAndWait(command1);
        }catch (Exception e){
            e.printStackTrace();
            result1 = e.getLocalizedMessage();
        }
        return result1;

    }

    @DeleteMapping
    public String deleteProduct(){
        return "user delete";
    }

}
