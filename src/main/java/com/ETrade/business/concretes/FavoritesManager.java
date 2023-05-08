package com.ETrade.business.concretes;

import com.ETrade.business.abstracts.FavoritesService;
import com.ETrade.dataAccess.abstracts.FavoritesRepository;
import com.ETrade.dto.responses.GetAllFavoritesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoritesManager implements FavoritesService {
    private FavoritesRepository favoritesRepository;

    @Override
    public List<GetAllFavoritesResponse> getAll() {
        return null;
    }
}
