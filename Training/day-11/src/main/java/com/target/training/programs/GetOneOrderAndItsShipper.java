package com.target.training.programs;

import com.target.training.entity.Orders;
import com.target.training.entity.Shippers;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneOrderAndItsShipper {

    public static void main(String[] args) {
        // select COMPANY_NAME from SHIPPERS join ORDERS on ORDERS.SHIP_VIA=SHIPPERS.SHIPPER_ID where ORDERS.ORDER_ID=11070

        EntityManager em = null;
        try{
            em = JpaUtil.createEntityManager();
            Orders order = em.find(Orders.class,11074);
//            Shippers shipper = em.find(Shippers.class,1 );
            log.debug("Shipper: {}", order.getShippers().getCompanyName());
//            System.out.println(shipper.getCompanyName());

        }
        finally{
            if(em!=null){
                em.close();
            }

        }
    }
}
