package com.example.orders.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Builder
@Entity
@Table(name = "product_offer")
public class ProductOfferEntity extends BaseProductEntity {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id",unique=true, nullable = false)
//    private Long id;


    private Long price;

    private LocalDate fromDate;

    private LocalDate toDate;

    @ManyToOne
    private ProviderEntity providerEntity;
}