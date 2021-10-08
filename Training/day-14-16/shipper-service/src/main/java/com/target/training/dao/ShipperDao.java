package com.target.training.dao;

import com.target.training.entity.Shippers;
import org.springframework.data.repository.CrudRepository;

public interface ShipperDao extends CrudRepository<Shippers, Integer> {
}
