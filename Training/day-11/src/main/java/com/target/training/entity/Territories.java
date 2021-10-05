package com.target.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TERRITORIES")
public class Territories {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "TERRITORY_ID")
    private Integer territoryId;
    @Column(name = "TERRITORY_DESCRIPTION")
    private String territoryDescription;
    @Column(name = "REGION_ID", insertable = false, updatable = false)
    private String regionId;


    @OneToMany
    @JoinColumn(name = "TERRITORY_ID")
    private List<EmployeeTerritories> employeeTerritories;


    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Regions regions;
}
