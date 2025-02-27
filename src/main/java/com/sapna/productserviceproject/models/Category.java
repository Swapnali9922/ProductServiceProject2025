package com.sapna.productserviceproject.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Setter
@Getter
public class Category extends BaseModel{
    private int id;
    private String title;
}
