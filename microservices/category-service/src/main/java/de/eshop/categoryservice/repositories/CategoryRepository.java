package de.eshop.categoryservice.repositories;

import de.eshop.categoryservice.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();
    Category findByIdCategory(Integer id);

    void saveCategory(Category category);

    void deleteCategoryById(Integer id);
}
