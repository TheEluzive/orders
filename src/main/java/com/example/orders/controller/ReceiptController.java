package com.example.orders.controller;

import com.example.orders.model.ReceiptRequest;
import com.example.orders.model.dto.ReceiptDto;
import com.example.orders.model.dto.ReportRequestDto;
import com.example.orders.model.entity.Report;
import com.example.orders.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @GetMapping("/getAll")
    public List<ReceiptDto> getAll(@RequestParam("offset") Integer offset,
                                   @RequestParam("limit") Integer limit){
        return receiptService.getAll(PageRequest.of(offset, limit));
    }

    @PostMapping("/register")
    public List<ReceiptDto> registerReceipt(@RequestBody ReceiptRequest request){
        return receiptService.register(request.getReceipts());
    }

    @PostMapping("/getReport")
    public List<Report> getReport(@RequestBody ReportRequestDto reportRequestDto){
        return receiptService.getReport(reportRequestDto.getFromDate(), reportRequestDto.getToDate());
    }

}
