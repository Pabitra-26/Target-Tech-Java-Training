package com.target.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SHIPPERS")
public class Shippers {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "SHIPPER_ID")
    private Integer shipperId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "PHONE")
    private String phone;

    @OneToMany
    @JoinColumn(name = "SHIP_VIA")
    private List<Orders> shipOrdersList;

    @Override
    public String toString() {
        return "Shippers{" +
                "shipperId=" + shipperId +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
