package com.target.training.service;

import com.target.training.dao.ShipperDao;
import com.target.training.entity.Shippers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultShipperService implements ShipperService{

    @Autowired
    private ShipperDao dao;

    @Override
    public Shippers addNewShipper(Shippers shipper) {
        shipper.setShipperId(null);
        return dao.save(shipper);
    }

    @Override
    public Shippers updateShipper(Shippers shipper) {
        if(shipper.getShipperId() == null){
            throw new RuntimeException("Shipper must have id for updating");
        }
        if(! dao.existsById(shipper.getShipperId())){
            throw new RuntimeException("Shipper has invalid id. Couldn't update");
        }
        return dao.save(shipper);
    }

    @Override
    public void deleteShipper(Integer id) {

        if(!dao.existsById(id)){
            throw new RuntimeException("Shipper has invalid id. Couldn't delete");
        }
        dao.deleteById(id);
    }

    @Override
    public Iterable<Shippers> getAllShippers() {
        return dao.findAll();
    }
}
