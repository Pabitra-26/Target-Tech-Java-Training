package com.target.training.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Transient
    private Customer customer;

    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

    @Column(name = "SHIP_VIA")
    private Integer shipVia;

    @Column(name = "FREIGHT")
    private Double freight;
//    @Column (name = "SHIP_NAME")
//    private String shipName;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private List<LineItem> items;




}
