package com.project.ecommerce.service;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public String create(Product prod){
        try{
            productRepository.save(prod);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String msg = prod.getName()+" product successfully created!";

        return msg;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product findOneById(int id){
        Product prodDb = productRepository.findById(id).orElse(null);
        return prodDb;
    }

    public String update(Product prod){
        String msg = "";
        Product prodDb = productRepository.findById(prod.getId()).orElse(null);
        if(prodDb!=null){
            productRepository.save(prod);
            msg = "Product with id "+prod.getId()+" successfully updated!";
        }
        else{
            msg = "Updated product not found";
        }

        return msg;
    }

    public String delete(int id){
        String msg = "";
        Product prodDb = productRepository.findById(id).orElse(null);
        if(prodDb!=null){
            productRepository.delete(prodDb);
            msg = "Product with id "+id+" successfully deleted!";
        }
        else{
            msg = "Product with id "+id+" not found";
        }

        return msg;
    }
}
