package com.ETrade.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "productId")
    private Long productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    private double productPrice;

    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;

}
