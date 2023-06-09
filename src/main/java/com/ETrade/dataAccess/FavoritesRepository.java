package com.ETrade.dataAccess;

import com.ETrade.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
}
