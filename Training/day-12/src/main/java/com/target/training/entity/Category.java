package com.target.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PICTURE")
    private byte[] picture;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> productList;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
