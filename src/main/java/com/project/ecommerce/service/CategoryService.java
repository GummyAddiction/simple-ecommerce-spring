package com.project.ecommerce.service;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public String create(Category cat){
        try{
            categoryRepository.save(cat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String msg = cat.getName()+" category successfully created!";

        return msg;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category findOneById(int id){
        Category catDb = categoryRepository.findById(id).orElse(null);
        return catDb;
    }

    public String update(Category cat){
        String msg = "";
        Category catDb = categoryRepository.findById(cat.getId()).orElse(null);
        if(catDb!=null){
            categoryRepository.save(cat);
            msg = "Category with id "+cat.getId()+" successfully updated!";
        }
        else{
            msg = "Updated category not found";
        }

        return msg;
    }

    public String delete(int id){
        String msg = "";
        Category catDb = categoryRepository.findById(id).orElse(null);
        if(catDb!=null){
            categoryRepository.delete(catDb);
            msg = "Category with id "+id+" successfully deleted!";
        }
        else{
            msg = "Category with id "+id+" not found";
        }

        return msg;
    }
}
