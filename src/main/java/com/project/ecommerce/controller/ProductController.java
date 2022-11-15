package com.project.ecommerce.controller;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product prod){
        
        return ResponseEntity.ok(productService.create(prod));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> allProduct(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> detailProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.findOneById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product prod){
        return ResponseEntity.ok(productService.update(prod));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.delete(id));
    }
}
