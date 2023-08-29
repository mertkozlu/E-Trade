package com.ETrade.business;

import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.FavoritesRepository;
import com.ETrade.dto.requests.CreateFavoriteRequest;
import com.ETrade.dto.responses.GetAllFavoriteResponse;
import com.ETrade.entities.Favorites;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    private final FavoritesRepository favoritesRepository;
    private final ModelMapperService modelMapperService;
    private final UserService userService;
    private final ProductService productService;

    public FavoriteService(FavoritesRepository favoritesRepository, ModelMapperService modelMapperService,
                           UserService userService, ProductService productService) {
        this.favoritesRepository = favoritesRepository;
        this.modelMapperService = modelMapperService;
        this.userService = userService;
        this.productService = productService;
    }

    public List<GetAllFavoriteResponse> getAllFavorites() {
        List<Favorites> favorites = favoritesRepository.findAll();

        List<GetAllFavoriteResponse> favoriteResponses = favorites.stream()
                .map(Favorites -> this.modelMapperService.forResponse()
                        .map(favorites, GetAllFavoriteResponse.class)).collect(Collectors.toList());
        return favoriteResponses;
    }

    public Favorites crateOneFavorite(CreateFavoriteRequest createFavoriteRequest) {
        Favorites favorites = this.modelMapperService.forRequest().map(createFavoriteRequest, Favorites.class);

        return this.favoritesRepository.save(favorites);
    }

    public void deleteOneFavorite(Long favoriteId) {
        Favorites favorites = favoritesRepository.findById(favoriteId).orElseThrow(() -> new BusinessException("Favorites can not found."));
        this.favoritesRepository.deleteById(favoriteId);
    }
}
