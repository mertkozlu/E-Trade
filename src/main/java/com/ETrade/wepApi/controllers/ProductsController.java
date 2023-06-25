package com.ETrade.wepApi.controllers;

import com.ETrade.business.ProductService;
import com.ETrade.dto.requests.CreateProductRequest;
import com.ETrade.dto.responses.GetAllProductResponse;
import com.ETrade.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAllProducts(@RequestParam Optional<Long> categoryId,
                                                      @RequestParam Optional<String> categoryName) {
        return productService.getAllProducts(categoryId, categoryName);
    }

    @PostMapping("/add")
    public Product createOneProduct(@RequestBody CreateProductRequest newProduct) {
        return productService.saveOneProduct(newProduct);
    }
}
