package com.example.orders.model;

import com.example.orders.model.dto.ProductRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductRequest {
    private Long providerId;
    private List<ProductRequestDto> products;
}
