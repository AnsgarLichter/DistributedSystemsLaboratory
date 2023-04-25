package de.eshop.categoryservice.controller;

import de.eshop.categoryservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<String>> getCategories(){
        var categoryList = this.categoryService.getCategoryService();
        return new ResponseEntity<List<String>>(categoryList, HttpStatus.OK);
    }
}
