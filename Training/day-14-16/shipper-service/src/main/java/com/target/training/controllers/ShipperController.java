package com.target.training.controllers;

import com.target.training.entity.ApiError;
import com.target.training.entity.Shippers;
import com.target.training.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    ShipperService service;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewShipper(@RequestBody Shippers shipper){
        try{
            Shippers s = service.addNewShipper(shipper);
            return ResponseEntity.ok(s);
        } catch (Exception e){
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @GetMapping(produces = "application/json")
    public Iterable<Shippers> handleGetAllShipper()
    {
        return service.getAllShippers();
    }


    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateShipper(@PathVariable Integer id, @RequestBody Shippers shipper){
        try{
            shipper.setShipperId(id);
            Shippers s = service.updateShipper(shipper);
            return ResponseEntity.ok(s);
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }

    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Object handleDeleteShipper(@PathVariable Integer id){
        try{
            service.deleteShipper(id);
            return "Delete successfully!";
        }
        catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }


}
