package com.ETrade.wepApi.controllers;

import com.ETrade.business.concretes.CategoryService;
import com.ETrade.dto.responses.GetAllCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping()
    public List<GetAllCategoriesResponse> getAll() {
        return this.categoryService.getAll();
    }

}
