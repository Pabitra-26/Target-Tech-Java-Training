package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.entity.Supplier;
import com.target.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllSuppliers {

    public static void main(String[] args) {

        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();

            TypedQuery<Supplier> qry = em.createQuery("from Supplier", Supplier.class);

            List<Supplier> list = qry.getResultList();
            list.forEach(System.out::println);
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
