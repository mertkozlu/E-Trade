package com.ETrade.dto.responses;

import com.ETrade.entities.Category;
import lombok.Data;

@Data
public class GetAllCategoryResponse {
    private Long categoryId;
    private String categoryName;

    public GetAllCategoryResponse(Category entity) {
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategoryName();
    }
}
