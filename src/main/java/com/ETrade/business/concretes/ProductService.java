package com.ETrade.business.concretes;

import com.ETrade.dataAccess.abstracts.ProdcutRepository;
import com.ETrade.dto.requests.CreateProductRequest;
import com.ETrade.dto.requests.UpdateProductRequest;
import com.ETrade.dto.responses.GetAllProductsResponse;
import com.ETrade.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProdcutRepository prodcutRepository;


    public List<GetAllProductsResponse> getAll() {

        List<Product> products = prodcutRepository.findAll();
        List<GetAllProductsResponse> productResponse = new ArrayList<GetAllProductsResponse>();

        for (Product product : products) {
            GetAllProductsResponse responseItem = new GetAllProductsResponse();
            responseItem.setProductId(product.getProductId());
            responseItem.setProductName(product.getProductName());
        }
        return productResponse;
    }

    public GetAllProductsResponse getById(int productId) {
        return null;
    }


    public void add(CreateProductRequest createProductRequest) {

    }

    public void update(UpdateProductRequest updateProductRequest) {

    }

    public void deleteById(int productId) {

    }
}
