package com.ETrade.businessRules;

import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.exceptions.CategoryNotFoundException;
import com.ETrade.dataAccess.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public void categoryName(String categoryName) {
        if (categoryName.isEmpty()) {
            throw new CategoryNotFoundException("Category name can not is empty");
        }
    }
}
