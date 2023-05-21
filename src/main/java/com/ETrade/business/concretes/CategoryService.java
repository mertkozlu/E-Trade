package com.ETrade.business.concretes;


import com.ETrade.dataAccess.abstracts.CategoryRepository;
import com.ETrade.dto.requests.CreateCategoryRequest;
import com.ETrade.dto.responses.GetAllCategoriesResponse;
import com.ETrade.dto.responses.GetByIdCategoryResponse;
import com.ETrade.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;


    public List<GetAllCategoriesResponse> getAll() {

        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponse = new ArrayList<GetAllCategoriesResponse>();

        for (Category category : categories) {
            GetAllCategoriesResponse responseItem = new GetAllCategoriesResponse();
            responseItem.setCategoryId(category.getCategoryId());
            responseItem.setCategoryName(category.getCategoryName());
        }
        return categoriesResponse;
    }


    public GetByIdCategoryResponse getById(int categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new Exception("Category could not find !");
        }
        return new GetByIdCategoryResponse(category);
    }

    public void add(CreateCategoryRequest createCategoryRequest) {

    }

    public void update(CreateCategoryRequest createCategoryRequest) {

    }

    public void deleteById(int categoryId) {

    }
}
