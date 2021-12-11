package com.example.demo.command;

import com.example.demo.command.rest.UpdateChangpassModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitCommand {
    @Autowired
    private final CommandGateway commandGateway;


    public RabbitCommand(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

//    @RabbitListener(queues = "Changepassword")
//    public String changpass(UpdateChangepassCommand command1){
//
//        String result1;
//        try{
//            result1 = commandGateway.sendAndWait(command1);
//        }catch (Exception e){
//            e.printStackTrace();
//            result1 = e.getLocalizedMessage();
//        }
//        return result1;
//
//    }
}
