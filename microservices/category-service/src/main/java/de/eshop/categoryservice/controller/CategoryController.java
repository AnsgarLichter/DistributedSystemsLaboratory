package de.eshop.categoryservice.controller;

import de.eshop.categoryservice.models.Category;
import de.eshop.categoryservice.services.CategoryService;
import de.eshop.categoryservice.clients.ProductsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    private ProductsClient productsClient;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(this.categoryService.findAllCategories(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable Long id) {
        return new ResponseEntity<>(this.categoryService.findCategory(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addCategory(@RequestBody Category category) {
        this.categoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        var products = productsClient.getProducts(id, null, null, null);
        if (products.size() > 0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("A category can only be deleted if there aren't any products linked to it.");
        }

        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
