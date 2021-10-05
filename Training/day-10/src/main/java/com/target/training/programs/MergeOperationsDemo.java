package com.target.training.programs;


import com.target.training.entity.Employee;
import com.target.training.util.DateUtil;
import com.target.training.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MergeOperationsDemo {

    public static void main(String[] args) {

        Employee emp = new Employee(1,"John Doe", DateUtil.toDate("2009-10-12"), 3500.0, "john.doe@gmail.com");

        EntityManager em = JpaUtil.createEntityManager();
        em.merge(emp);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();


    }
}
