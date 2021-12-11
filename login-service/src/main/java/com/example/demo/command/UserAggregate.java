package com.example.demo.command;

import com.example.demo.core.event.UserChangepassEvent;
import com.example.demo.core.event.UserCreatedEvent;
import com.example.demo.core.event.UserUpdateEvent;
import com.example.demo.core.event.UserUpdateIdCardEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class UserAggregate {


    @AggregateIdentifier
    private  String id;
    private  String f_name;
    private  String l_name;
    private  String username;
    private  String password;
    private  String email;
    private  String phone_number;
    private  String usertype;
    private String idCard;
    private String pictureIdCard;


    public UserAggregate(){

    }

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand) {
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(createUserCommand, userCreatedEvent);
        AggregateLifecycle.apply(userCreatedEvent);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent){
        this.id = userCreatedEvent.getId();
        this.f_name = userCreatedEvent.getF_name();
        this.l_name = userCreatedEvent.getL_name();
        this.username = userCreatedEvent.getUsername();
        this.password = userCreatedEvent.getPassword();
        this.email = userCreatedEvent.getEmail();
        this.phone_number = userCreatedEvent.getPhone_number();
        this.usertype = userCreatedEvent.getUsertype();
    }

    @CommandHandler
    public void handle(UpdateUserCommand updateUserCommand){
        UserUpdateEvent userUpdateEvent = new UserUpdateEvent();
        BeanUtils.copyProperties(updateUserCommand, userUpdateEvent);
        AggregateLifecycle.apply(userUpdateEvent);
    }

    @EventSourcingHandler
    public void on(UserUpdateEvent userUpdateEvent){
        this.id = userUpdateEvent.getId();
        this.f_name = userUpdateEvent.getF_name();
        this.email = userUpdateEvent.getEmail();
        this.l_name = userUpdateEvent.getL_name();
        this.phone_number = userUpdateEvent.getPhone_number();
    }


    @CommandHandler
    public void handle(UserUpdateIdCardCommand userUpdateIdCardCommand){
        UserUpdateIdCardEvent userUpdateEvent = new UserUpdateIdCardEvent();
        BeanUtils.copyProperties(userUpdateIdCardCommand, userUpdateEvent);
        AggregateLifecycle.apply(userUpdateEvent);
    }


    @EventSourcingHandler
    public void on(UserUpdateIdCardEvent userUpdateIdCardEvent){
        this.id = userUpdateIdCardEvent.getId();
        this.idCard = userUpdateIdCardEvent.getIdCard();
        this.pictureIdCard = userUpdateIdCardEvent.getPictureIdCard();

    }


    @CommandHandler
    public void handle(UpdateChangepassCommand updateChangepassCommand){
        UserChangepassEvent userChangepassEvent = new UserChangepassEvent();
        BeanUtils.copyProperties(updateChangepassCommand, userChangepassEvent);
        AggregateLifecycle.apply(userChangepassEvent);
    }

    @EventSourcingHandler
    public void on(UserChangepassEvent userChangepassEvent){
        this.id = userChangepassEvent.getId();
        this.password = userChangepassEvent.getNewpass();


    }



}
