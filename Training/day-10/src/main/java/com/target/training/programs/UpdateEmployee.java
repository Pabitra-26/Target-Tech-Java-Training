package com.target.training.programs;

import com.target.training.entity.Employee;
import com.target.training.util.DateUtil;
import com.target.training.util.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


@Slf4j
public class UpdateEmployee {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Jane Doe", 3500.0, "jane.doe@gmail.com");

        EntityManager em = JpaUtil.createEntityManager();

        Employee emp = em.find(Employee.class, 1);
        log.debug("emp = {}", emp);

        emp.setHireDate(DateUtil.toDate("1999-05-26"));


        em.persist(emp1);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();

        em.close();
    }
}
