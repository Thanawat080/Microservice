package com.service.store.command.rest;

import com.service.store.command.CreateStoreCommand;

import com.service.store.command.ReportCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/store")
public class StoreController {


    private final CommandGateway commandGateway;

    @Autowired
    public StoreController(CommandGateway commandGateway){this.commandGateway = commandGateway;}

    @PostMapping
    public String createStore(@RequestParam("id") String id,@RequestParam("rent_type") String rent_type, @RequestParam("description") String description, @RequestParam("storename") String store, @RequestParam("file") MultipartFile file) throws IOException {

        CreateStoreCommand command = CreateStoreCommand.builder().storeId(UUID.randomUUID().toString()).storename(store).description(description).rent_type(rent_type).reportnumber(0).sellerId(id).picture(file.getOriginalFilename()).build();
        File saveFile = new File("C:\\Users\\Earth\\Desktop\\store-service\\src\\main\\resources\\static", file.getOriginalFilename());

        saveFile.createNewFile();
        try(FileOutputStream fout = new FileOutputStream(saveFile)){
            fout.write(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @PutMapping("/report/{id}/{report}")
    public String reportStore(@PathVariable("id") String id, @PathVariable("report") int report){
        ReportCommand command1 = ReportCommand.builder().storeId(id).report(report).build();
        String result1;
        try{
            result1 = commandGateway.sendAndWait(command1);
        }catch (Exception e){
            e.printStackTrace();
            result1 = e.getLocalizedMessage();
        }
        return result1;
    }

}
