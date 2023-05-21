package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class UpdateFavoritesRequest {
    private int favoriteId;
    private String favoriteName;
}
