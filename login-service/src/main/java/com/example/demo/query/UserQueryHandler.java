package com.example.demo.query;

import com.example.demo.core.UserEntity;
import com.example.demo.core.event.data.UserRepository;
import com.example.demo.query.rest.UserRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserQueryHandler {
    private final UserRepository userRepository;

    public UserQueryHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @QueryHandler
    List<UserRestModel> findUsers(FindUserQuery query){
        List<UserRestModel> userRest = new ArrayList<>();
        List<UserEntity> storeUsers = userRepository.findAll();
        for(UserEntity userEntity : storeUsers){
            UserRestModel userRestModel = new UserRestModel();
            BeanUtils.copyProperties(userEntity, userRestModel);
            userRest.add(userRestModel);
        }
        return userRest;
    }

    @QueryHandler
    UserEntity findUserById(FindUserByIdQuery query){
        UserEntity storeUsers = userRepository.findById(query.getId()).get();
        return storeUsers;
    }

    @QueryHandler
    UserRestModel findByUnameandP(FindByUsernameAndPassword query){
        UserRestModel userRest = new UserRestModel();
        UserEntity user = userRepository.findByUsernameAndPassword(query.getUsename(), query.getPassword());
        BeanUtils.copyProperties(user, userRest);
        return userRest;
    }
}
