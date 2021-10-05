package com.target.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "EMPLOYEE_TERRITORIES")
public class EmployeeTerritories implements Serializable {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer EmployeeId;
    @Id
    @Column(name = "TERRITORY_ID")
    private Integer TerritoryId;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employees employees;


    @ManyToOne
    @JoinColumn(name = "TERRITORY_ID")
    private Territories territories;
}
