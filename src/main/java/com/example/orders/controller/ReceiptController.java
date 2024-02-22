package com.example.orders.controller;

import com.example.orders.model.*;
import com.example.orders.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @GetMapping("/getAll")
    public List<Receipt> getAll(){
        return receiptService.getAll();
    }

    @PostMapping("/register")
    public List<Receipt> registerReceipt(@RequestBody ReceiptRequest request){
        return receiptService.register(request.getReceipts());
    }

    @PostMapping("/getReport")
    public List<Report> getReport(@RequestBody ReportDto reportDto){
        return receiptService.getReport(reportDto.getFromDate(), reportDto.getToDate());
    }

}
