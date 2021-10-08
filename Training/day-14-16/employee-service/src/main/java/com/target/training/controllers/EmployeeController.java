package com.target.training.controllers;


import com.target.training.entity.ApiError;
import com.target.training.entity.Employees;
import com.target.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewEmployee(@RequestBody Employees employee){
        try{
            Employees e = service.addNewEmploye(employee);
            return ResponseEntity.ok(e);
        } catch (Exception e){
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @GetMapping(produces = "application/json")
    public Iterable<Employees> handleGetAllEmployees()
    {
        return service.getAllEmployees();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Employees handleGetOneEmployee(@PathVariable Integer id){
        Optional<Employees> op = service.getEmployeeById(id);
        if(op.isPresent()){
            return op.get();
        }
        throw new EmployeeNotFoundException("No employee found for id " + id);
    }


    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateEmployee(@PathVariable Integer id, @RequestBody Employees employee){
        try{
            employee.setEmployeeId(id);
            Employees p = service.updateEmployee(employee);
            return ResponseEntity.ok(p);
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }

    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Object handleDeleteEmployee(@PathVariable Integer id){
        try{
            service.deleteEmployee(id);
            return "Delete successfully!";
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }

}
