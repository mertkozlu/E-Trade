package com.ETrade.wepApi.controllers;

import com.ETrade.business.CategoryService;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.dto.requests.UpdateCategoryRequest;
import com.ETrade.dto.responses.GetAllCategoryResponse;
import com.ETrade.entities.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<GetAllCategoryResponse> getAll() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public Category createOneCategory(@RequestBody CreateCategoryRequest newCategory) {
        return categoryService.createOneCategory(newCategory);
    }

    @PutMapping("/{categoryId}")
    public Category updateOneCategory(@PathVariable Long categoryId, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return categoryService.updateOneCategoryById(categoryId, updateCategoryRequest);
    }

    @GetMapping("/{categoryId}")
    public GetAllCategoryResponse getOneCategory(@PathVariable Long categoryId) {
        return categoryService.getOneCategory(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteById(@PathVariable Long categoryId) {
        this.categoryService.deleteById(categoryId);
    }

}
