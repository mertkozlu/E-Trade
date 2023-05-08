package com.ETrade.business.concretes;

import com.ETrade.business.abstracts.ProductService;
import com.ETrade.dataAccess.abstracts.ProdcutRepository;
import com.ETrade.dto.responses.GetAllProductsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProdcutRepository prodcutRepository;

    @Override
    public List<GetAllProductsResponse> getAll() {
        return null;
    }

    @Override
    public GetAllProductsResponse getById(int id) {
        return null;
    }
}
