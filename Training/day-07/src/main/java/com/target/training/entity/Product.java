package com.target.training.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
