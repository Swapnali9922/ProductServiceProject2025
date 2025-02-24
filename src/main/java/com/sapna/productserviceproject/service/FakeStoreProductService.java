package com.sapna.productserviceproject.service;

import com.sapna.productserviceproject.dtos.FakeStoreProductServicedtos;
import com.sapna.productserviceproject.models.Category;
import com.sapna.productserviceproject.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAllProducts(){
        List<Product> response=new ArrayList<>();
        ResponseEntity<FakeStoreProductServicedtos[]> fakestoreproducts=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductServicedtos[].class);
        //next step
       System.out.println("StatusCode:"+fakestoreproducts.getStatusCode());
        for(FakeStoreProductServicedtos fakestorepro :fakestoreproducts.getBody()){
                response.add(converttoproduct(fakestorepro));
        }
        //convert the response into List<products>
        return response;
    }



    public Product createProduct(String title,String imageurl,String cattitle,String description){
        Product response;
        FakeStoreProductServicedtos requestBody=new FakeStoreProductServicedtos();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImageUrl(imageurl);
        requestBody.setCategory(cattitle);
   FakeStoreProductServicedtos fakestoreresponse=restTemplate.postForObject("https://fakestoreapi.com/products/",requestBody, FakeStoreProductServicedtos.class);

        response=converttoproduct(fakestoreresponse);
        return response;
    }

}
