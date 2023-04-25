package de.eshop.categoryservice.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public List<String> getCategoryService(){
        List<String> categoryList = new ArrayList<>();
        categoryList.add("Test1");
        categoryList.add("Test2");
        categoryList.add("Test3");
        return categoryList;
    }
}
