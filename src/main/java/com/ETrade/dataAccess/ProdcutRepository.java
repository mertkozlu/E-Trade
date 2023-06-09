package com.ETrade.dataAccess;

import com.ETrade.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Product, Long> {
}
