package com.ajinkya.major.dto;

import com.ajinkya.major.model.Category;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;


}
