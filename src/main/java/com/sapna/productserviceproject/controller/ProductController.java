package com.sapna.productserviceproject.controller;

import com.sapna.productserviceproject.models.Product;
import com.sapna.productserviceproject.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private FakeStoreProductService service;

    public ProductController(FakeStoreProductService InputService){
        service=InputService;

    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Integer id){


        return service.getProductById(id);
    }
}
