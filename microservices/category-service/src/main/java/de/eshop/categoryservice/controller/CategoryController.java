package de.eshop.categoryservice.controller;

import de.eshop.categoryservice.models.Category;
import de.eshop.categoryservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getCategories(){
        var categoryList = this.categoryService.findAllCategories();
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Category> getCategory(@PathVariable Integer id){
        var category = this.categoryService.findCategory(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addCategory(@RequestBody Category category){
        this.categoryService.addCategory(category);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
    }
}
