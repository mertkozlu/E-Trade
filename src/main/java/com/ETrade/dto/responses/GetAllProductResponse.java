package com.ETrade.dto.responses;

import com.ETrade.entities.Product;
import lombok.Data;

import java.util.Date;

@Data
public class GetAllProductResponse {
    private Long categoryId;
    private String categoryName;
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    Date createDate;

    public GetAllProductResponse(Product entity) {
        this.productId = entity.getProductId();
        this.productName = entity.getProductName();
        this.productDescription = entity.getProductDescription();
        this.productPrice = entity.getProductPrice();

        if (entity.getCategory() != null) {
            this.categoryId = entity.getCategory().getCategoryId();
            this.categoryName = entity.getCategory().getCategoryName();
        } else
            this.categoryName = null;
            this.categoryId = null;
    }
}
