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

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
        return new ResponseEntity<Optional<Product>>(this.service.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        this.service.add(product);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        this.service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}