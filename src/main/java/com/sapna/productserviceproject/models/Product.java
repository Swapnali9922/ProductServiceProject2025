package com.sapna.productserviceproject.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private int id;
    private String title;
    private String description;
    private String imageurl;
    private Category category;

}
