package com.example.orders.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "provider")
public class ProviderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "providerEntity")
    @JsonIgnore
    private List<ProductOfferEntity> productOfferList;
}
