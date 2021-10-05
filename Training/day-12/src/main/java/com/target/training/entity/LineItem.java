package com.target.training.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ORDER_DETAILS")
public class LineItem {
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;
}
