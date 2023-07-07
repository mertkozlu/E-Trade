package com.ETrade.dto.requests;

import com.ETrade.entities.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {
    private Long categoryId;
    @NotNull
    @NotBlank
    private String productName;
    @NotNull
    @NotBlank
    private String productDescription;
    @NotNull
    private double productPrice;


}
