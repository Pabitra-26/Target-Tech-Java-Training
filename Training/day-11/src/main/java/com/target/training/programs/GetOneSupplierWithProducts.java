package com.target.training.programs;

import com.target.training.entity.Category;
import com.target.training.entity.Supplier;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneSupplierWithProducts {

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            Supplier s = em.find(Supplier.class, 20);
            // select * from PRODUCTS inner join SUPPLIERS on PRODUCTS.SUPPLIER_ID=SUPPLIERS.SUPPLIER_ID where SUPPLIERS.SUPPLIER_ID=20 \G;
            log.debug("Company name = {}", s.getCompanyName());
            log.debug("Contact name = {}", s.getContactName());
            log.debug("Contact title = {}", s.getContactTitle());
            log.debug("Address = {}", s.getAddress());
            log.debug("City = {}", s.getCity());
            log.debug("Region = {}", s.getRegion());
            log.debug("Postal Code = {}", s.getPostalCode());
            log.debug("Country = {}", s.getCountry());
            log.debug("Phone = {}", s.getPhone());
            log.debug("Fax = {}", s.getFax());
            log.debug("Home Page = {}", s.getHomePage());

            log.debug("Products supplied by this supplier are : ");
            s.getProductsList().forEach(System.out::println);
            for(int i=0; i<s.getProductsList().size();i++){
                System.out.println(s.getProductsList().get(i));
            }


        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
