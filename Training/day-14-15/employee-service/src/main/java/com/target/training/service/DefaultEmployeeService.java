package com.target.training.service;


import com.target.training.dao.EmployeeDao;
import com.target.training.entity.Employees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class DefaultEmployeeService implements EmployeeService{

    @Autowired
    private EmployeeDao dao;


    @Override
    public Employees addNewEmploye(Employees employee) {
        employee.setEmployeeId(null);
        return dao.save(employee);
    }

    @Override
    public Employees updateEmployee(Employees employee) {
        if(employee.getEmployeeId() == null){
            throw new RuntimeException("Product must have id for updating");
        }
        if(! dao.existsById(employee.getEmployeeId())){
            throw new RuntimeException("Product has invalid id. Couldn't update");
        }
        return dao.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        if(!dao.existsById(id)){
            throw new RuntimeException("Employee has invalid id. Couldn't delete");
        }
        dao.deleteById(id);

    }

    @Override
    public Iterable<Employees> getAllEmployees() {
        return dao.findAll();
    }
}
