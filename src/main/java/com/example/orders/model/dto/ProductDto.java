package com.example.orders.model.dto;

import com.example.orders.model.entity.CategoryEntity;
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

    private long id;

    private String name;

    private CategoryDto category;

    private Long weight;

    private Long price;

    private LocalDate fromDate;

    private LocalDate toDate;

    private ProviderDto provider;

}
