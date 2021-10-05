package com.target.training.entity;


import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")

public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private String customerId;
    @Column(name = "EMPLOYEE_ID", insertable = false, updatable = false)
    private Integer employeeId;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;
    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;
    @Column(name = "SHIP_VIA", insertable = false, updatable = false)
    private Integer shipVia;
    @Column(name = "FREIGHT")
    private Double freight;
    @Column (name = "SHIP_NAME")
    private String shipName;
    @Column (name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column (name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_REGION")
    private String shipRegion;
    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;
    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;

    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<OrderDetails> getOrderDetails;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employees employees;


    @ManyToOne
    @JoinColumn(name = "SHIPPER_ID")
    private Shippers shippers;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customerId='" + customerId + '\'' +
                ", employeeId=" + employeeId +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", shipVia=" + shipVia +
                ", freight=" + freight +
                ", shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                '}';
    }
}
