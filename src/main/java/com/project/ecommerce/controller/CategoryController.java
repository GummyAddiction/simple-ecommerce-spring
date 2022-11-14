package com.project.ecommerce.controller;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<String> createCategory(@RequestBody Category cat){
        return ResponseEntity.ok(categoryService.create(cat));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> allCategory(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Category> detailCategory(@PathVariable("id") int id){
        return ResponseEntity.ok(categoryService.findOneById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody Category cat){
        return ResponseEntity.ok(categoryService.update(cat));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
