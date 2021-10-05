package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class GetOneProductWithCategory {

    public static void main(String[] args) {

        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            Product p = em.find(Product.class, 1);

            //log.debug("Product for id 10 is {}", p);
            log.debug("Name = {}", p.getProductName());
            log.debug("Category = {}",p.getCategory().getCategoryName());
            log.debug("Description = {}", p.getCategory().getDescription());
            FileOutputStream file = new FileOutputStream(p.getCategory().getCategoryName()+"_"+System.currentTimeMillis()+".png");
            file.write(p.getCategory().getPicture());
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
