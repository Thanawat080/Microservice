package com.example.demo.command.rest;

import com.example.demo.command.CreateUserCommand;

import com.example.demo.command.UpdateChangepassCommand;
import com.example.demo.command.UpdateUserCommand;
import com.example.demo.command.UserUpdateIdCardCommand;
import com.example.demo.core.UserEntity;
import lombok.Data;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserCommandController {


    private final CommandGateway commandGateway;
    @Autowired
    private RabbitTemplate rabbitTemplate;
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
    @PostMapping("/addcheck/openstore")
    public String updateIdCardUser(@RequestParam("id") String id, @RequestParam("pictureIdCard") MultipartFile pictureIdCard, @RequestParam("idCard") String idCard) throws IOException {
        UserUpdateIdCardCommand command1 = UserUpdateIdCardCommand.builder().id(id).pictureIdCard(pictureIdCard.getOriginalFilename()).idCard(idCard).build();
        File saveFile = new File("C:\\Users\\Earth\\Desktop\\login-service\\src\\main\\resources\\static", pictureIdCard.getOriginalFilename());

        saveFile.createNewFile();
        String result1;
        try(FileOutputStream fout = new FileOutputStream(saveFile)){
            fout.write(pictureIdCard.getBytes());
            result1 = commandGateway.sendAndWait(command1);
        }catch (Exception e){
            e.printStackTrace();
            result1 = e.getLocalizedMessage();
        }
        return result1;

    }


    @PutMapping("/changepassword")
    public String updateUserPassword(@RequestBody UpdateChangpassModel updateChangpassModel){
        UpdateChangepassCommand command1 = UpdateChangepassCommand.builder().id(updateChangpassModel.getId()).oldpass(updateChangpassModel.getOldpass()).newpass(updateChangpassModel.getNewpass()).build();
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
