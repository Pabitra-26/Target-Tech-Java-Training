package com.target.training.dao;

import com.target.training.entity.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository <Customers, String>{

}
