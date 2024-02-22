package com.example.orders.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ProductOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;


    private String name;

    @ManyToOne
    private Category category; //todo: new Entity

    private Long price;

    private Long weight;

    private Long amount;


    private LocalDate fromDate;

    private LocalDate toDate;

    @ManyToOne
    private Provider provider;
}
