package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private Long categoryId;
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;

}
