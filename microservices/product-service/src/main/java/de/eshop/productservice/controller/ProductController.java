package de.eshop.productservice.controller;

import de.eshop.productservice.models.Product;
import de.eshop.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false, defaultValue = "0.0") Double minimumPrice,
            @RequestParam(required = false) Double maximumPrice
    ) {
        if(categoryId != null) {
            return new ResponseEntity<>(this.service.findByCategory(categoryId), HttpStatus.OK);
        }

        return new ResponseEntity<>(this.service.findBySearchCriteria(search, minimumPrice, maximumPrice), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(
    ) {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        this.service.add(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}