package com.target.training.programs;

import com.sun.security.jgss.GSSUtil;
import com.target.training.entity.Order;
import com.target.training.utils.DateUtil;
import com.target.training.utils.JpaUtil;
import com.target.training.utils.KeyboardUtil;

import javax.management.MBeanAttributeInfo;
import javax.persistence.EntityManager;

public class GetOrderDetails {
    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter order id to get details for: ");
        EntityManager em = JpaUtil.createEntityManager();
        Order order = em.find(Order.class, orderId);

        printOrderInformation(order);




        em.close();
    }

    static void printOrderInformation(Order order){
        System.out.println("Order id                 :" + order.getOrderId());
        System.out.println("Order date               :" + DateUtil.toString(order.getOrderDate()));
        System.out.println("Required date            :" + DateUtil.toString(order.getRequiredDate()));
        if(order.getShippedDate()!=null){
            System.out.println("Shipped date           :" + DateUtil.toString(order.getShippedDate()));
        }


    }
}
