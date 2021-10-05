package com.target.training.programs;

import com.target.training.entity.Category;
import com.target.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllCategories {

    public static void main(String[] args) {

        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();

            TypedQuery<Category> qry = em.createQuery("from Category", Category.class);

            List<Category> list = qry.getResultList();
            list.forEach(System.out::println);
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
