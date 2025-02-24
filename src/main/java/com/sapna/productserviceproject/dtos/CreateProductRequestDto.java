package com.sapna.productserviceproject.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private String imageURl;
    private CategoryRequestDto category;

}
