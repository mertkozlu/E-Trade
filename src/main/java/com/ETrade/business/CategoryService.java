package com.ETrade.business;


import com.ETrade.businessRules.CategoryBusinessRules;
import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.CategoryRepository;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.dto.requests.UpdateCategoryRequest;
import com.ETrade.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public Category updateOneCategoryById(Long categoryId, UpdateCategoryRequest updateCategoryRequest) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (Objects.nonNull(category)) {
            category.setCategoryName(updateCategoryRequest.getCategoryName());
            categoryRepository.save(category);
            return category;
        }
        throw new BusinessException("Category could not found");
    }
}
