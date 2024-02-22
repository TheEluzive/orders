package com.example.orders.service;

import com.example.orders.model.Receipt;
import com.example.orders.model.ReceiptDto;
import com.example.orders.model.Report;
import com.example.orders.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReceiptService {
    private ProductService productService;
    private ReceiptRepository receiptRepository;

    public List<Receipt> register(List<ReceiptDto> receipts){
       return receiptRepository.saveAll(receipts.stream().map(r -> {
            Receipt receipt = new Receipt();
            receipt.setProduct(productService.getById(r.getProductId())); // todo: package
            receipt.setAmount(r.getAmount());
            receipt.setDateReceipt(LocalDate.now());
            return receipt;
        }).toList());
    }

    public List<Receipt> getAll() {
        return receiptRepository.findAll();
    }

    public List<Report> getReport(LocalDate fromDate, LocalDate toDate) {
        return receiptRepository.getSumWeightAndPriceByProvider(fromDate, toDate);
    }
}
