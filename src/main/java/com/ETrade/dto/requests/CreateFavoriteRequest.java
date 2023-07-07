package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class CreateFavoriteRequest {
    private Long productId;
    private Long userId;
}
