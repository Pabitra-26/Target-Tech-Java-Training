package com.target.training.controllers;

import com.target.training.entity.Order;
import com.target.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;


    @GetMapping(path = "/{id}", produces = "application/json")
    public Order handleGetOrderById(@PathVariable Integer id){
        return service.getOrderById(id);
    }

}
