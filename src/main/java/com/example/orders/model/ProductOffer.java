package com.example.orders.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Builder
@Entity
public class ProductOffer extends BaseProduct{
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id",unique=true, nullable = false)
//    private Long id;


    private Long price;

    private LocalDate fromDate;

    private LocalDate toDate;

    @ManyToOne
    private Provider provider;
}