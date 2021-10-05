package com.target.training.dao;

import com.target.training.entity.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employees, Integer> {
}
