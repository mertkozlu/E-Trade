package com.ETrade.business.concretes;

import com.ETrade.dataAccess.abstracts.FavoritesRepository;
import com.ETrade.dto.requests.CreateFavoritesRequest;
import com.ETrade.dto.requests.UpdateFavoritesRequest;
import com.ETrade.dto.responses.GetAllCategoriesResponse;
import com.ETrade.dto.responses.GetAllFavoritesResponse;
import com.ETrade.dto.responses.GetByIdCategoryResponse;
import com.ETrade.entities.concretes.Favorites;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavoritesService {
    private FavoritesRepository favoritesRepository;

    public List<GetAllFavoritesResponse> getAll() {

        List<Favorites> favorites = favoritesRepository.findAll();
        List<GetAllFavoritesResponse> favoritesResponse = new ArrayList<GetAllFavoritesResponse>();

        for (Favorites favorites1 : favorites) {
            GetAllFavoritesResponse responseItem = new GetAllFavoritesResponse();
            responseItem.setId(favorites1.getId());
            responseItem.setName(favorites1.getName());
        }
        return favoritesResponse;
    }

    public GetAllFavoritesResponse getById(int id) {
        return null;
    }

    public void add(CreateFavoritesRequest createFavoritesRequest) {

    }

    public void update(UpdateFavoritesRequest updateFavoritesRequest) {

    }

    public void deleteById(int id) {

    }
}
