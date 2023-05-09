package com.ETrade.wepApi.controllers;

import com.ETrade.business.concretes.ProductService;
import com.ETrade.dto.responses.GetAllProductsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping()
    public List<GetAllProductsResponse> getAll() {
        return this.productService.getAll();
    }
}
