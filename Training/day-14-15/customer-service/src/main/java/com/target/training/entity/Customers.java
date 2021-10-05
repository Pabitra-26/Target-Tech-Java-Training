package com.target.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customers {
    @Id

    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "REGION")
    private String region;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;

}
