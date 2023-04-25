package de.eshop.categoryservice.repositories;

import de.eshop.categoryservice.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
