package com.example.orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private String name;

    private String category;

    private Long price;

    private Long weight;

    private Long amount;

    private LocalDate fromDate;

    private LocalDate toDate;
}
