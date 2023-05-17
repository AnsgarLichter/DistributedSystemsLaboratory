package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import hska.iwi.eShopMaster.clients.ProductsClient;
import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.ProductDAO;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;
import hska.iwi.eShopMaster.model.database.dataobjects.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManagerImpl implements ProductManager {
    private ProductDAO helper;

    private final ProductsClient productsClient = Feign.builder()
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .target(ProductsClient.class, "http://product-service:8081/api/v1/products");

    public ProductManagerImpl() {
        helper = new ProductDAO();
    }

    public List<Product> getProducts() {
        return productsClient.getProducts();
    }

    public List<Product> getProductsForSearchValues(String searchDescription,
                                                    Double searchMinPrice, Double searchMaxPrice) {

        Map<String, Object> queryMap = new HashMap<String, Object>();
        if (searchDescription != null) {
            queryMap.put("search", searchDescription);
        }

        if (searchMinPrice != null) {
            queryMap.put("minimumPrice", searchMinPrice);
        }

        if (searchMaxPrice != null) {
            queryMap.put("maximumPrice", searchMaxPrice);
        }

        return productsClient.search(queryMap);
    }

    public Product getProductById(int id) {
        return productsClient.getProduct((long) id);
    }

    public Product getProductByName(String name) {
        return null;
    }

    public int addProduct(String name, double price, int categoryId, String details) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", name);
        requestBody.put("price", price);
        requestBody.put("categoryId", categoryId);
        requestBody.put("details", details);
        Product product = productsClient.createProduct(requestBody);

        return product.getId();
    }


    public void deleteProductById(int id) {
        productsClient.deleteProduct((long) id);
    }

    public boolean deleteProductsByCategoryId(int categoryId) {
        return false;
    }

}
