package com.service.store.command.rest;

import com.service.store.command.CreateProductCommand;

import com.service.store.command.DeleteCommand;
import com.service.store.command.UpdateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/product")
public class ProductController {


    private final CommandGateway commandGateway;

    @Autowired
    public ProductController(CommandGateway commandGateway){this.commandGateway = commandGateway;}

    @PostMapping
    public String createStore(@RequestParam("file") MultipartFile[] file, @RequestParam("product_name") String product_name, @RequestParam("price") Integer price, @RequestParam("quantity") Integer quantity, @RequestParam("description") String description, @RequestParam("storeId") String storeId, @RequestParam("category") String category) throws IOException {
        List<String> fileNames = new ArrayList<>();
        try {

            Arrays.asList(file).stream().forEach(file1 -> {
                fileNames.add(file1.getOriginalFilename());
                File saveFile = new File("C:\\Users\\Earth\\Desktop\\product-service\\src\\main\\resources\\static", file1.getOriginalFilename());
                try {
                    saveFile.createNewFile();
                    try(FileOutputStream fout = new FileOutputStream(saveFile)){
                        fout.write(file1.getBytes());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        CreateProductCommand command = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .pic(fileNames)
                .product_name(product_name)
                .price(price)
                .quantity(quantity)
                .category(category)
                .description(description)
                .storeId(storeId).build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }


    @PostMapping("/editproduct")
    public String updateproduct(@RequestBody UpdateProductModel updateProductModel){

        UpdateProductCommand command1 = UpdateProductCommand.builder().quantity(updateProductModel.getQuantity()).description(updateProductModel.getDescription()).category(updateProductModel.getCategory()).product_name(updateProductModel.getProduct_name()).price(updateProductModel.getPrice()).id(updateProductModel.getId()).build();
        String result1;
        try{
            result1 = commandGateway.sendAndWait(command1);
        }catch (Exception e){
            e.printStackTrace();
            result1 = e.getLocalizedMessage();
        }
        return result1;
    }


    @DeleteMapping("/deleteproduct/{id}")
    public void deleteproduct(@PathVariable("id") String id){
        DeleteCommand command1 = DeleteCommand.builder().id(id).build();
         commandGateway.sendAndWait(command1);

    }



}
