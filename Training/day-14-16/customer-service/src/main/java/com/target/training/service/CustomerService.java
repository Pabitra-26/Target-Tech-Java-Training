package com.target.training.service;

import com.target.training.entity.Customers;

import java.util.Optional;

public interface CustomerService {
    public Customers addNewCustomer(Customers customer);

    public Customers updateCustomer(Customers customer);
    public void deleteCustomer(String id);

    public Iterable<Customers> getAllCustomers();
    public Optional<Customers> getCustomerById(String id);
}
