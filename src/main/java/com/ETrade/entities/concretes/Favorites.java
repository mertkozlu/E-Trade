package com.ETrade.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoritesId")
    private Long favoriteId;
    @Column(name = "favoritesName")
    private String favoriteName;
}
