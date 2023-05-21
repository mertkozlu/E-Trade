package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private int productId;
    private String productName;
}
