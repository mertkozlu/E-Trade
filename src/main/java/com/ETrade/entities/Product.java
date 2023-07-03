package com.ETrade.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    private double productPrice;

    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorites_id",nullable = false)
    @JsonIgnore
    private Favorites favorites;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;




}
