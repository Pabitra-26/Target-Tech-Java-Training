package com.target.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.NavigableMap;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "SUPPLIER_ID", insertable = false, updatable = false)
    private Integer supplierId;
    @Column(name = "CATEGORY_ID", insertable = false, updatable = false)
    private Integer categoryId;

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

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<OrderDetails> getOrderDetails;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", supplierId=" + supplierId +
                ", categoryId=" + categoryId +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitsInStock=" + unitsInStock +
                ", unitsOnOrder=" + unitsOnOrder +
                ", reorderLevel=" + reorderLevel +
                ", discontinued=" + discontinued +
                '}';
    }
}
