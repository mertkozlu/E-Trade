package com.ETrade.dto.responses;

import lombok.Data;

@Data
public class GetByIdCategoryResponse {
    private int categoryId;
    private String categoryName;
}
