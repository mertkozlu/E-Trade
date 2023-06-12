package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class CreateCategoryRequest {
    private Long categoryId;
    private String categoryName;

}
