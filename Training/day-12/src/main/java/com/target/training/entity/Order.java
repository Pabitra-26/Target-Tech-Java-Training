package com.target.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;
    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;
    @Column(name = "FREIGHT")
    private Double freight;
    @Column(name = "SHIP_NAME")
    private String shipName;
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column(name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_REGION")
    private String shipRegion;
    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;
    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;


    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customers customer;


    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<LineItem> LineItems;

}
