package com.target.training.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "QUANTITY_PER_UNIT")
    private String quantityPerUnit;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;
    @Column(name = "UNITS_IN_STOCK")
    private Integer unitsInStock;
    @Column(name = "UNITS_ON_ORDER")
    private Integer unitsOnOrder;
    @Column(name = "REORDER_LEVEL")
    private Integer reorderLevel;
    @Column(name = "DISCONTINUED")
    private Integer discontinued;
}