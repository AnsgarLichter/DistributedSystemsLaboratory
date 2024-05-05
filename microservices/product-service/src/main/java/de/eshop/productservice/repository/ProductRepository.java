package de.eshop.productservice.repository;

import de.eshop.productservice.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("from Product p where p.categoryId=:categoryId")
    Iterable<Product> findByCategory(Long categoryId);

    @Query("from Product p where (p.name LIKE :keyword OR p.details LIKE :keyword) AND p.price BETWEEN :minPrice AND :maxPrice")
    Iterable<Product> findBySearchCriteria(String keyword, double minPrice, double maxPrice);

    @Query("from Product p where (p.name LIKE :keyword OR p.details LIKE :keyword) AND p.price >= :minPrice")
    Iterable<Product> findByKeywordAndMinPrice(String keyword, double minPrice);

    @Query("from Product p where (p.name LIKE :keyword OR p.details LIKE :keyword) AND p.price <= :maxPrice")
    Iterable<Product> findByKeywordAndMaxPrice(String keyword, double maxPrice);

    @Query("from Product p where (p.name LIKE :keyword OR p.details LIKE :keyword)")
    Iterable<Product> findByKeyword(String keyword);

    @Query("from Product p where p.price <= :maxPrice")
    Iterable<Product> findByMaxPrice(double maxPrice);

    @Query("from Product p where p.price >= :minPrice")
    Iterable<Product> findByMinPrice(double minPrice);

}
