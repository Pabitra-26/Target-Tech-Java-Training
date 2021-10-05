package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.utils.JpaUtil;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class GetAllProducts {

    public static void main(String[] args) {

        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();

            TypedQuery<Product> qry = em.createQuery("from Product", Product.class);

            List<Product> list = qry.getResultList();
            list.forEach(System.out::println);
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
