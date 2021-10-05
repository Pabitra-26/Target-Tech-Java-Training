package com.target.training.service;

import com.target.training.dao.ProductDao;
import com.target.training.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;

@Slf4j
@Service
public class DefaultProductService implements ProductService{

    @Autowired
    private ProductDao dao;

    @Override
    public Product addNewProduct(Product product) {
        //inorder to ensure that save() does INSERT, we have to set product's id to null
        product.setProductId(null);
        //do all validations about product's members before saving
        return dao.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> op = dao.findById(id);
        Product p = null;
        if(op.isPresent()){
            p = op.get();
        }
        log.debug("Product for {} is {}", id, p);
        return p;
    }

    @Override
    public Product updateProduct(Product product) {
        if(product.getProductId() == null){
            throw new RuntimeException("Product must have id for updating");
        }
        if(! dao.existsById(product.getProductId())){
            throw new RuntimeException("Product has invalid id. Couldn't update");
        }
        return dao.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        if(!dao.existsById(id)){
            throw new RuntimeException("Product has invalid id. Couldn't delete");
        }

        //soft delete

        // hard delete
//        dao.deleteById(id);
        Product p = dao.findById(id).get();
        p.setDiscontinued(1);

        return dao.save(p);
    }




    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize) {
        PageRequest p = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> result = dao.findAll(p);

        if(result.hasContent()){
            return result.getContent();
        }
        else{
            return new ArrayList<>();
        }

    }

    @Override
    public Iterable<Product> getDiscontinuedProducts() {
        return dao.findByDiscontinued(1);
    }

    @Override
    public Iterable<Product> getNoDiscontinuedProducts() {
        return dao.findByDiscontinued(0);
    }

    @Override
    public Iterable<Product> getProductsBetween(Double min, Double max) {
        return dao.findByPriceRange(min,max);
    }
}
