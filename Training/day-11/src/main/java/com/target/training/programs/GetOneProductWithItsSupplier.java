package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Slf4j
public class GetOneProductWithItsSupplier {
    public static void main(String[] args) {

        EntityManager em = null;
        // select PRODUCT_NAME, COMPANY_NAME, SUPPLIERS.SUPPLIER_ID from SUPPLIERS join PRODUCTS on SUPPLIERS.SUPPLIER_ID=PRODUCTS.SUPPLIER_ID where PRODUCTS.PRODUCT_ID=20;
        try {
            em = JpaUtil.createEntityManager();
            Product p = em.find(Product.class, 20);


            log.debug("Product Name = {}", p.getProductName());
            log.debug("Supplier name = {}", p.getSupplier().getCompanyName());
            log.debug("Supplier id = {}", p.getSupplier().getSupplierId());
        }

//            FileOutputStream file = new FileOutputStream(p.getCategory().getCategoryName()+"_"+System.currentTimeMillis()+".png");
//            file.write(p.getCategory().getPicture());
//            file.close();

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        finally {
            if(em != null){
                em.close();
            }
        }
    }
}
