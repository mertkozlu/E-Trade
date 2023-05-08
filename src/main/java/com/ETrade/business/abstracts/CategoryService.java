package com.ETrade.business.abstracts;

import com.ETrade.dto.responses.GetAllCategoriesResponse;
import com.ETrade.dto.responses.GetByIdCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetByIdCategoryResponse getById(int id);
}
