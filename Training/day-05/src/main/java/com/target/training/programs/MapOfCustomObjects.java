package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.utils.KeyboardUtil;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class MapOfCustomObjects {
    public static void main(String[] args) {

        Map<Integer, Product> products = new HashMap<>();

        Product p;
        p = new Product(12, "Apple magic mouse", 8000.0);
        products.put(p.getId(), p);
        p = new Product(87, "Dell mouse", 6500.);
        products.put(p.getId(), p);
        p = new Product(19, "Apple pencil", 8500.0);
        products.put(p.getId(), p);
        p = new Product(78, "Logitech Keyboard", 700.0);
        products.put(p.getId(), p);

        int id = KeyboardUtil.getInt("Enter id to search: ");
        if(products.containsKey(id)){
            p = products.get(id);
            System.out.println(p);
        }
        else{
            System.out.println("No product found for id " + id);
        }

    }
}
