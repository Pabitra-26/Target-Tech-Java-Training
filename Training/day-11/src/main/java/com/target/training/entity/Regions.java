package com.target.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "REGIONS")
public class Regions {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "REGION_ID")
    private Integer regionId;
    @Column(name = "REGION_DESCRIPTION")
    private String regionDescription;


    @OneToMany
    @JoinColumn(name = "REGION_ID")
    private List<Territories> territoriesList;
}
