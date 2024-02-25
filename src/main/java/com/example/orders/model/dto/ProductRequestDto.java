package com.example.orders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDto {

    private String name;

    private String category;

    private Long price;

    private Long weight;

    private LocalDate fromDate;

    private LocalDate toDate;
}
