package com.sapna.productserviceproject.controller;

import com.sapna.productserviceproject.Exception.ProductNotFoundException;
import com.sapna.productserviceproject.dtos.CreateProductRequestDto;
import com.sapna.productserviceproject.models.Product;
import com.sapna.productserviceproject.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private FakeStoreProductService service;

    public ProductController(FakeStoreProductService InputService){
        service=InputService;

    }
    //get single product
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        if(id==100)
            throw new IllegalArgumentException("id should not be 100");
        Product product=service.getProductById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found");
        }
        return product;
    }

    //get All products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        //s1.Any validation if you want to do

        List<Product> products=service.getAllProducts();
        return products;
    }
    //create new products
    @PostMapping("/product")
    public Product CreateProduct(@RequestBody CreateProductRequestDto request){
        return service.createProduct(request.getTitle(),request.getImageURl(),request.getCategory().getTitle(),request.getDescription());


    }
//    private Product convertDtotoProduct(CreateProductRequestDto request){
//        Product product=new Product();
//        product.setTitle(request.getTitle());
//        product.setDescription(request.getDescription());
//        product.setImageurl(request.getImageURl());
//        return product;
//    }

}
