package com.ETrade.dataAccess.abstracts;

import com.ETrade.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
