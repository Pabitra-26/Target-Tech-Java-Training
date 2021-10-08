package com.target.training.service;


import com.target.training.dao.OrderDao;
import com.target.training.entity.Customer;
import com.target.training.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    @Value("${microservices.url.customer-service}")
    private String customerServiceUrl;

    public Order getOrderById(Integer id) {
        Optional<Order> op = dao.findById(id);

        if (op.isPresent()) {
            Order order = op.get();

            String url = customerServiceUrl+order.getCustomerId();
            log.debug("Visiting the customer service using the url{}", url);

            try {
                RestTemplate rt = new RestTemplate();
                Customer customer = rt.getForObject(url, Customer.class);
                order.setCustomer(customer);
            } catch (RestClientException e) {
                log.error("There was an exception ", e);
            }
            return order;
        }
        throw new RuntimeException("No order found for id " + id);
    }
}
