package com.example.orders.model;

import com.example.orders.model.dto.ProviderRequestDto;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProviderRequest {
    private List<ProviderRequestDto> providers;
}
