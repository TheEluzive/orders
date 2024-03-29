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
public class ReceiptDto {
    private ProductDto productDto;
    private Long amount;
    private LocalDate dateReceipt;
}
