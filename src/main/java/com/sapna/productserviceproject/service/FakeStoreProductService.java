package com.sapna.productserviceproject.service;

import com.sapna.productserviceproject.dtos.FakeStoreProductServicedtos;
import com.sapna.productserviceproject.models.Category;
import com.sapna.productserviceproject.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService {

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }
    public Product getProductById(Integer id){
        //call fakestoreapi-----Restemplate
        Product product = new Product();

        ResponseEntity<FakeStoreProductServicedtos>  fakestoreresponse= restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, FakeStoreProductServicedtos.class);
        //get response
        FakeStoreProductServicedtos response=fakestoreresponse.getBody();

        //convert the response into product model
        //return
       product=converttoproduct(response);
         return product;

    }
    public Product converttoproduct(FakeStoreProductServicedtos response){
        Product product=new Product();
        Category category=new Category();
        category.setTitle(response.getTitle());
        product.setId(response.getId());
        product.setTitle(response.getTitle());
        product.setDescription(response.getDescription());
        product.setImageurl(response.getImageUrl());
        product.setCategory(category);

        return product;
    }
}
