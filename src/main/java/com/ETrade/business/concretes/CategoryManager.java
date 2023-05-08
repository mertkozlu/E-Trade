package com.ETrade.business.concretes;

import com.ETrade.business.abstracts.CategoryService;
import com.ETrade.dataAccess.abstracts.CategoryRepository;
import com.ETrade.dto.responses.GetAllCategoriesResponse;
import com.ETrade.dto.responses.GetByIdCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdCategoryResponse getById(int id) {
        return null;
    }
}
