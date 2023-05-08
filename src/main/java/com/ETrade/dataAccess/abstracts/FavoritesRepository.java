package com.ETrade.dataAccess.abstracts;

import com.ETrade.entities.concretes.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {
}
