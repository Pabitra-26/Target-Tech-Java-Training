package com.target.training.service;

import com.target.training.entity.Employees;

import java.util.Optional;

public interface EmployeeService {

    public Employees addNewEmploye(Employees employee);
    public Employees updateEmployee(Employees employee);
    public void deleteEmployee(Integer id);
    public Iterable<Employees> getAllEmployees();
    public Optional<Employees> getEmployeeById(Integer id);
}
