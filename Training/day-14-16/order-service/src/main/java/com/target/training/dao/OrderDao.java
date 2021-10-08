package com.target.training.dao;

import com.target.training.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Integer> {
}
