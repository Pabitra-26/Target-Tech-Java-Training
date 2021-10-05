package com.target.training.controllers;


import com.target.training.entity.ApiError;
import com.target.training.entity.Customers;
import com.target.training.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    CustomerService service;

    @PostMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public ResponseEntity<Object> handleAddNewCustomer(@RequestBody Customers customer){
        try{
            Customers c = service.addNewCustomer(customer);
            return ResponseEntity.ok(c);
        } catch (Exception e){
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @GetMapping(produces = APPLICATION_JSON)
    public Iterable<Customers> handleGetAllCustomers()
    {
    return service.getAllCustomers();
    }


    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public ResponseEntity<Object> handleUpdateCustomer(@PathVariable String id, @RequestBody Customers customer){
        try{
           customer.setCustomerId(id);
            Customers p = service.updateCustomer(customer);
            return ResponseEntity.ok(p);
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }

    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON)
    public Object handleDeleteCustomer(@PathVariable String id){
        try{
            service.deleteCustomer(id);
            return "Delete successfully!";
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON)
    public Customers handleGetOneCustomer(@PathVariable String id){
        Optional<Customers> op = service.getCustomerById(id);
        if(op.isPresent()){
            return op.get();
        }
        throw new CustomerNoFoundException("No customer found for id " + id);
    }


}
