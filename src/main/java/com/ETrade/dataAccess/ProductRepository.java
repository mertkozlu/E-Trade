package com.ETrade.dataAccess;

import com.ETrade.entities.Category;
import com.ETrade.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_CategoryIdAndCategory_CategoryName(Long categoryId, String categoryName);

    List<Product> findByCategory_CategoryId(Long categoryId);

    List<Product> findByCategory_CategoryName(String categoryName);
}
