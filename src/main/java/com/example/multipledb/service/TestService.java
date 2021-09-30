package com.example.multipledb.service;

import com.example.multipledb.dao.product.ProductRepo;
import com.example.multipledb.dao.user.UserRepo;
import com.example.multipledb.entity.product.Product;
import com.example.multipledb.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

@Service
public class TestService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;


    @Transactional("chainedTransactionManager")
    public void doSmtg(){

        Product product=new Product(1,"T-shirt");
        productRepo.save(product);

        User user=new User();
        user.setId(2);
        user.setName(null);
        user.setPassword("sdasasdsadsad");

        userRepo.save(user);
    }

}
