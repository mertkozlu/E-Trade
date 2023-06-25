package com.ETrade.business;


import com.ETrade.businessRules.CategoryBusinessRules;
import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.CategoryRepository;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.dto.requests.UpdateCategoryRequest;
import com.ETrade.dto.responses.GetAllCategoryResponse;
import com.ETrade.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;
    private final CategoryBusinessRules categoryBusinessRules;

    public CategoryService(CategoryRepository categoryRepository, ModelMapperService modelMapperService,
                           CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    public List<GetAllCategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> categoryResponse = categories.stream().map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
        return categoryResponse;
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

    public GetAllCategoryResponse getOneCategory(Long categoryId) {
        Category category = categoryRepository.getById(categoryId);
        if (category == null) {
            throw new BusinessException("Category could not found");
        }
        GetAllCategoryResponse getAllCategoryResponse = this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class);
        return getAllCategoryResponse;
    }

    public void deleteById(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

}
