package com.example.demo.query;

import com.example.demo.core.UserEntity;
import com.example.demo.core.data.UserRepository;
import com.example.demo.core.event.UserCreatedEvent;
import com.example.demo.core.event.UserUpdateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {
    private final UserRepository userRepository;

    public UserEventHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(UserCreatedEvent event){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userRepository.save(userEntity);
    }

    @EventHandler
    public void on(UserUpdateEvent event){
        UserEntity userEntity = userRepository.findById(event.getId()).get();
        userEntity.setF_name(event.getF_name());
        userEntity.setEmail(event.getEmail());
        userEntity.setL_name(event.getL_name());
        userEntity.setPhone_number(event.getPhone_number());
        userRepository.save(userEntity);
    }


}
