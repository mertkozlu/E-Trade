package com.ETrade.wepApi.controllers;

import com.ETrade.business.FavoriteService;
import com.ETrade.dto.requests.CreateFavoriteRequest;
import com.ETrade.dto.responses.GetAllFavoriteResponse;
import com.ETrade.entities.Favorites;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {
    private final FavoriteService favoriteService;


    public FavoritesController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/getAll")
    public List<GetAllFavoriteResponse> getAll() {
        return favoriteService.getAllFavorites();
    }

    @PostMapping("/add")
    public Favorites add(@RequestBody CreateFavoriteRequest createFavoriteRequest) {
        return favoriteService.crateOneFavorite(createFavoriteRequest);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteOneFavorite(@PathVariable Long favoriteId) {
        this.favoriteService.deleteOneFavorite(favoriteId);
    }


}
