package com.target.training.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "DISCOUNT")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders order;


    @Override
    public String toString() {
        return "OrderDetails{" +
                "unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
