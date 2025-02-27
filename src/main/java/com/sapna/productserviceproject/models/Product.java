package com.sapna.productserviceproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private int id;
    private String title;
    private String description;
    private String imageurl;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Category category;


}
