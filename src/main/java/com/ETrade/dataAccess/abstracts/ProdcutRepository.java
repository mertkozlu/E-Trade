package com.ETrade.dataAccess.abstracts;

import com.ETrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Product, Integer> {
}
