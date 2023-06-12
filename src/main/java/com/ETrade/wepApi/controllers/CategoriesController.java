package com.ETrade.wepApi.controllers;

import com.ETrade.business.CategoryService;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.entities.Category;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public Category createOneCategory(@RequestBody CreateCategoryRequest newCategory) {
        return categoryService.createOneCategory(newCategory);
    }


}
