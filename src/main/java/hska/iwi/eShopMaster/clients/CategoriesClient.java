package hska.iwi.eShopMaster.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

import hska.iwi.eShopMaster.model.database.dataobjects.Category;

public interface CategoriesClient {
    @RequestLine("GET")
    List<Category> getCategories();
    @RequestLine("GET /{id}")
    Category getCategory(@Param("id") Long id);

    @RequestLine("DELETE /{id}")
    void deleteCategory(@Param("id") Long id);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void createCategory(Map<String, Object> requestBody);
}
