package com.target.training.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employees {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TITLE_OF_COURTESY")
    private String titleOfCourtesy;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "HIRE_DATE")
    private Date hireDate;
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
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "EXTENSION")
    private String extension;
    @Column(name = "PHOTO")
    private byte[] photo;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "REPORT_TO")
    private Integer reportTo;

    @OneToMany
    @JoinColumn(name = "EMPLOYEE_ID")
    private List<Orders> getOrders;


    @OneToMany
    @JoinColumn(name = "EMPLOYEE_ID")
    private List<Employees> employees;

    @OneToMany
    @JoinColumn(name = "EMPLOYEE_ID")
    private List<EmployeeTerritories> employeeTerritories;

}
