package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.entity.Shippers;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class GetOneShipperWithOrders {
    public static void main(String[] args) {


        //select * from SHIPPERS join ORDERS on ORDERS.SHIP_VIA=SHIPPERS.SHIPPER_ID where SHIPPERS.SHIPPER_ID=2 \G;
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            Shippers shipper = em.find(Shippers.class, 2);

            //log.debug("Product for id 10 is {}", p);
            log.debug("Name = {}", shipper.getCompanyName());
            log.debug("Shipper id = {}", shipper.getShipperId());

            for (int i = 0; i < shipper.getShipOrdersList().size(); i++) {
                System.out.println(shipper.getShipOrdersList().get(i));
//                System.out.println(i);
            }


        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
