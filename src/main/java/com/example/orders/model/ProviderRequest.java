package com.example.orders.model;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProviderRequest {
    private List<ProviderDto> providers;
}
