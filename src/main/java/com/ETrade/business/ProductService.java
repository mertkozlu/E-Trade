package com.ETrade.business;

import com.ETrade.businessRules.ProductBusinessRules;
import com.ETrade.core.utilities.exceptions.ProductNotFoundException;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.ProductRepository;
import com.ETrade.dto.requests.CreateProductRequest;
import com.ETrade.dto.requests.UpdateProductRequest;
import com.ETrade.dto.responses.GetAllProductResponse;
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

    public List<GetAllProductResponse> getAllProducts(Optional<Long> categoryId, Optional<String> categoryName) {
        List<Product> list;
        if (categoryId.isPresent() && categoryName.isPresent()) {
            list = productRepository.findByCategory_CategoryIdAndCategory_CategoryName(categoryId.get(), categoryName.get());
        } else if (categoryId.isPresent()) {
            list = productRepository.findByCategory_CategoryId(categoryId.get());
        } else if (categoryName.isPresent()) {
            list = productRepository.findByCategory_CategoryName(categoryName.get());
        } else
            list = productRepository.findAll();
        return list.stream().map(product -> new GetAllProductResponse(product)).collect(Collectors.toList());
    }

    public Product saveOneProduct(CreateProductRequest newProduct) {
        Product product = this.modelMapperService.forRequest().map(newProduct, Product.class);
        return this.productRepository.save(product);
//        this.productBusinessRules.productName(newProduct.getProductName());
//        Product toSave = new Product();
//        toSave.setProductName(newProduct.getProductName());
//        toSave.setProductPrice(newProduct.getProductPrice());
//        toSave.setProductDescription(newProduct.getProductDescription());
//        toSave.setCategory(newProduct.getCategory());
//
//        return productRepository.save(toSave);
    }

    public void updateOneProduct(Long productId, UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        productRepository.save(product);

    }


    public GetAllProductResponse getOneProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not available");
        }
        return new GetAllProductResponse(product);
    }

    public void deleteOneProduct(Long productId) {
        this.productRepository.deleteById(productId);
    }
}
