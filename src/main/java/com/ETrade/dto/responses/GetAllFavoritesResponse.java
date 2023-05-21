package com.ETrade.dto.responses;

import lombok.Data;

@Data
public class GetAllFavoritesResponse {
    private int favoriteId;
    private String favoriteName;
}
