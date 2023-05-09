package com.ETrade.wepApi.controllers;

import com.ETrade.business.concretes.FavoritesService;
import com.ETrade.dto.responses.GetAllFavoritesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@AllArgsConstructor
public class FavoritesController {
    private final FavoritesService favoritesService;

    @GetMapping()
    public List<GetAllFavoritesResponse> getAll() {
        return this.favoritesService.getAll();

    }
}
