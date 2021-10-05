package com.target.training.service;


import com.target.training.dao.CustomerDao;
import com.target.training.entity.Customers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerDao dao;


    @Override
    public Customers addNewCustomer(Customers customer) {
//        customer.setCustomerId(null);
        return dao.save(customer);
    }



    @Override
    public Customers updateCustomer(Customers customer) {
        if(customer.getCustomerId() == null){
            throw new RuntimeException("Product must have id for updating");
        }
        if(! dao.existsById(customer.getCustomerId())){
            throw new RuntimeException("Product has invalid id. Couldn't update");
        }
        return dao.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        if(!dao.existsById(id)){
            throw new RuntimeException("Customer has invalid id. Couldn't delete");
        }
        dao.deleteById(id);
    }

    @Override
    public Iterable<Customers> getAllCustomers() {
        return dao.findAll();

    }

    @Override
    public Optional<Customers> getCustomerById(String id) {
        return dao.findById(id);
    }
}
