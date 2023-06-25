package com.ETrade.dto.responses;

import com.ETrade.entities.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;

    public CategoryResponse(Category entity) {
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategoryName();
    }
}
