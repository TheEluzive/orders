package com.example.orders.model;

import com.example.orders.model.dto.ReceiptRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReceiptRequest {
    private List<ReceiptRequestDto> receipts;
}
