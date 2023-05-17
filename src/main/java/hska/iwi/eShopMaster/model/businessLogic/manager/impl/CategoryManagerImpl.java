package hska.iwi.eShopMaster.model.businessLogic.manager.impl;


import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import hska.iwi.eShopMaster.clients.CategoriesClient;
import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.CategoryDAO;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryManagerImpl implements CategoryManager {
    private CategoryDAO helper;

    private final CategoriesClient categoriesClient = Feign.builder()
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .target(CategoriesClient.class, "http://category-service:8080/api/v1/categories");

    public CategoryManagerImpl() {
        helper = new CategoryDAO();
    }

    public List<Category> getCategories() {
        return categoriesClient.getCategories();
    }

    public Category getCategory(int id) {
        return categoriesClient.getCategory((long) id);
    }

    public Category getCategoryByName(String name) {
        return null;
    }

    public void addCategory(String name) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", name);
        categoriesClient.createCategory(requestBody);
    }

    public void delCategory(Category cat) {
        categoriesClient.deleteCategory((long) cat.getId());
    }

    public void delCategoryById(int id) {
        categoriesClient.deleteCategory((long) id);
    }
}
