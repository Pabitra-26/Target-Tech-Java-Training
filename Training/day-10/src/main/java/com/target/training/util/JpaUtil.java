package com.target.training.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private JpaUtil(){

    }

    //a single copy of EntityManagerFactory
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
