package com.ETrade.dto.responses;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductResponse {
    private Long categoryId;
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    Date createDate;
}
