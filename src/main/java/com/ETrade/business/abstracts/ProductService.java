package com.ETrade.business.abstracts;

import com.ETrade.dto.responses.GetAllProductsResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();
    GetAllProductsResponse getById(int id);
}
