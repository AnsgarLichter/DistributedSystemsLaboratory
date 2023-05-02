package de.eshop.categoryservice.services;

import de.eshop.categoryservice.models.Category;
import de.eshop.categoryservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return this.categoryRepository.findAll();
    }

    public Category findCategory(Integer id){
        return this.categoryRepository.findByIdCategory(id);
    }

    public void addCategory(Category category){
        this.categoryRepository.saveCategory(category);
    }

    public void deleteCategory(Integer id){
        this.categoryRepository.deleteById(id);
    }
}
