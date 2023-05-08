package com.ETrade.business.abstracts;

import com.ETrade.dto.responses.GetAllFavoritesResponse;

import java.util.List;

public interface FavoritesService {
    List<GetAllFavoritesResponse> getAll();
}
