package de.eshop.productservice.services;

import de.eshop.productservice.repository.ProductRepository;
import de.eshop.productservice.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll() {
        return (List<Product>) this.repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return this.repository.findById(id);
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public void delete(Long id) {

    }
}