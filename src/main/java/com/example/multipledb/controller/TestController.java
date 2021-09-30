package com.example.multipledb.controller;


import com.example.multipledb.dao.product.ProductRepo;
import com.example.multipledb.dao.user.UserRepo;
import com.example.multipledb.entity.product.Product;
import com.example.multipledb.entity.user.User;
import com.example.multipledb.requestpayload.TestModel;
import com.example.multipledb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private TestService testService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TestModel testModel){
        User savedUser=userRepo.save(testModel.getUser());
        Product savedProduct= productRepo.save(testModel.getProduct());

        List<Object> response=new ArrayList<>();
        response.add(savedUser);
        response.add(savedProduct);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/1")
    public void test(){
        testService.doSmtg();
    }



}
