package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class UpdateCategoryRequest {
    private int categoryId;
    private String categoryName;

}
