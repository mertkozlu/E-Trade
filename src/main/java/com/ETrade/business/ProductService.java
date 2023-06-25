package com.ETrade.business;

import com.ETrade.businessRules.ProductBusinessRules;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.ProductRepository;
import com.ETrade.dto.requests.CreateProductRequest;
import com.ETrade.dto.responses.CategoryResponse;
import com.ETrade.dto.responses.ProductResponse;
import com.ETrade.entities.Category;
import com.ETrade.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapperService modelMapperService;
    private final ProductBusinessRules productBusinessRules;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ModelMapperService modelMapperService, ProductBusinessRules productBusinessRules, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
        this.productBusinessRules = productBusinessRules;
        this.categoryService = categoryService;
    }

    public List<ProductResponse> getAllProducts(Optional<Long> categoryId) {
        List<Product> list;
        if (categoryId.isPresent()) {
            list = productRepository.findAll();
            return list.stream().map(product -> new ProductResponse()).collect(Collectors.toList());
        }
        return null;
    }

    public Product saveOneProduct(CreateProductRequest newProduct) {
        return null;
    }
}
