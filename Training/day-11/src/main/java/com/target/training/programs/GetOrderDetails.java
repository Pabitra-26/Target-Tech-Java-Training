package com.target.training.programs;

import com.target.training.entity.OrderDetails;
import com.target.training.entity.Orders;
import com.target.utils.DateUtil;
import com.target.utils.JpaUtil;
import com.target.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;
import java.util.List;

public class GetOrderDetails {
    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter order id to get details for: ");
        EntityManager em = JpaUtil.createEntityManager();
        Orders order = em.find(Orders.class, orderId);

        printOrderInformation(order);
        line();
//        printCustomerDetails(order.getCustomer());
//        line();
//        // printShipperDetails(order.getShipper());
//        // printEmployeeDetails(order.getEmployee());
        printLineItems(order.getGetOrderDetails());

        em.close();
    }

    static void printLineItems(List<OrderDetails> lineItems) {
        System.out.println("Products in this order are:");
        line();
        System.out.printf("%-45s %10s %10s %10s %10s%n",
                "Product name", "Unit price", "Quantity", "Discount", "Amount");
        line();
        double total = 0;
        for(OrderDetails li: lineItems){
            System.out.printf("%-45s %10s %10s %10s %10.2f%n",
                    li.getProduct().getProductName() + " (" + li.getProduct().getCategory().getCategoryName() + ")",
                    li.getUnitPrice(),
                    li.getQuantity(),
                    li.getDiscount()*100 + "%",
                    (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity()));
            total += (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity());
        }
        line();
        System.out.printf("%78s %10.2f%n", "Total", total);
        line();
    }

    static void printOrderInformation(Orders order) {
        System.out.println("Order id                      : " + order.getOrderId());
        System.out.println("Order date                    : " + DateUtil.toString(order.getOrderDate()));
        System.out.println("Required date                 : " + DateUtil.toString(order.getRequiredDate()));
        if (order.getShippedDate() != null) {
            System.out.println("Shipped date                  : " + DateUtil.toString(order.getShippedDate()));
        }
        System.out.println("Shipped to                    : " + order.getShipName());
        System.out.println("                                " + order.getShipAddress());
        System.out.println("                                " + order.getShipCity());
        if (order.getShipRegion() != null) {
            System.out.println("                                " + order.getShipRegion());
        }
        System.out.println("                                " + order.getShipCountry() + " " + order.getShipPostalCode());

    }
    static void line() {
        for (int i = 0; i < 95; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
