package com.target.training.service;

import com.target.training.entity.Shippers;

public interface ShipperService {
    public Shippers addNewShipper(Shippers shipper);
    public Shippers updateShipper(Shippers shipper);
    public void deleteShipper(Integer id);
    public Iterable<Shippers> getAllShippers();



}
