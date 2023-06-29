package com.ETrade.dto.responses;

import lombok.Data;

@Data
public class GetAllFavoriteResponse {
    private Long favoriteId;
    private Long productId;
    private Long userId;

}
