package com.ETrade.business;


import com.ETrade.businessRules.CategoryBusinessRules;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.CategoryRepository;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ModelMapperService modelMapperService;
    private final CategoryBusinessRules categoryBusinessRules;

    public CategoryService (CategoryRepository categoryRepository, UserService userService,
                            ModelMapperService modelMapperService, CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.modelMapperService = modelMapperService;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createOneCategory(CreateCategoryRequest newCategory) {
        this.categoryBusinessRules.categoryName(newCategory.getCategoryName());
        Category category = this.modelMapperService.forRequest().map(newCategory, Category.class);
        return categoryRepository.save(category);
    }
}
