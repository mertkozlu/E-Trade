package com.ETrade.businessRules;

import com.ETrade.core.utilities.exceptions.ProductNotFoundException;
import com.ETrade.dataAccess.ProductRepository;
import com.ETrade.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository productRepository;

    public void productName(String productName) {
        if (productName.isEmpty()) {
            throw new ProductNotFoundException("Product name can not is empty.");
        }
    }
}
