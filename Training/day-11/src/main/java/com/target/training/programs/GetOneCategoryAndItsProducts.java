package com.target.training.programs;

import com.target.training.entity.Category;
import com.target.training.entity.Product;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOneCategoryAndItsProducts {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            Category c = em.find(Category.class, 8);
            log.debug("Category name = {}", c.getCategoryName());
            log.debug("Description = {}", c.getDescription());
            log.debug("Products in this category are : ");
            c.getProductList().forEach(System.out::println);




        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
