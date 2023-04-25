package de.eshop.categoryservice.services;

import de.eshop.categoryservice.models.Category;
import de.eshop.categoryservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> findAllCategories(){
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findCategory(Integer id){
        return this.categoryRepository.findById(id);
    }

    public void addCategory(Category category){
        this.categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        this.categoryRepository.deleteById(id);
    }
}
