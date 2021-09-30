package com.example.multipledb.requestpayload;

import com.example.multipledb.entity.product.Product;
import com.example.multipledb.entity.user.User;
import lombok.Data;

@Data
public class TestModel {
    private User user;
    private Product product;
}
