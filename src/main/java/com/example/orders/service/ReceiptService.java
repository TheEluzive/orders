package com.example.orders.service;

import com.example.orders.mapper.OrderMapper;
import com.example.orders.model.dto.ReceiptDto;
import com.example.orders.model.entity.ReceiptEntity;
import com.example.orders.model.dto.ReceiptRequestDto;
import com.example.orders.model.entity.Report;
import com.example.orders.repository.ProductRepository;
import com.example.orders.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiptService {
    private final ProductRepository productRepository;
    private final ReceiptRepository receiptRepository;
    private final OrderMapper mapper;

    public List<ReceiptDto> register(List<ReceiptRequestDto> receipts) {
        return receiptRepository.saveAll(receipts.stream().map(r -> {
                    ReceiptEntity receiptEntity = new ReceiptEntity();
                    receiptEntity.setProduct(productRepository.findById(r.getProductId()).orElseThrow(RuntimeException::new)); // todo: package
                    receiptEntity.setAmount(r.getAmount());
                    receiptEntity.setDateReceipt(LocalDate.now());
                    return receiptEntity;
                }).toList())
                .stream()
                .map(mapper::mapDaoToReceiptDto).collect(Collectors.toList());
    }


    public List<ReceiptDto> getAll() {
        return receiptRepository.findAll()
                .stream()
                .map(mapper::mapDaoToReceiptDto).collect(Collectors.toList());
    }

    public List<Report> getReport(LocalDate fromDate, LocalDate toDate) {
        return receiptRepository.getSumWeightAndPriceByProvider(fromDate, toDate);
    }
}
