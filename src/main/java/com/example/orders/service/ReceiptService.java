package com.example.orders.service;

import com.example.orders.exception.ProductNotFoundException;
import com.example.orders.exception.WrongProductDataException;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.model.dto.ReceiptDto;
import com.example.orders.model.dto.ReceiptRequestDto;
import com.example.orders.model.entity.ProductOfferEntity;
import com.example.orders.model.entity.ReceiptEntity;
import com.example.orders.model.entity.Report;
import com.example.orders.repository.ProductRepository;
import com.example.orders.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptService {
    private final ProductRepository productRepository;
    private final ReceiptRepository receiptRepository;
    private final OrderMapper mapper;

    public List<ReceiptDto> register(List<ReceiptRequestDto> receipts) {
        List<Long> productsOfferIds = receipts.stream().map(ReceiptRequestDto::getProductId).toList();
        List<ProductOfferEntity> productOfferEntities = productRepository.findAllByIdIn(productsOfferIds);
        return receiptRepository.saveAll(receipts.stream().map(r -> {
                            try {
                                ReceiptEntity receiptEntity = new ReceiptEntity();
                                ProductOfferEntity productOffer = productOfferEntities.stream()
                                        .filter(p -> p.getId() == r.getProductId())
                                        .findFirst()
                                        .orElseThrow(ProductNotFoundException::new);
                                if (productOffer.getFromDate().isBefore(LocalDate.now()) && productOffer.getToDate().isAfter(LocalDate.now()))
                                    receiptEntity.setProduct(productOffer);
                                else throw new WrongProductDataException();
                                receiptEntity.setAmount(r.getAmount());
                                receiptEntity.setDateReceipt(LocalDate.now());
                                return receiptEntity;
                            } catch (ProductNotFoundException e) {
                                log.error("Product wasn`t found, id: " + r.getProductId());
                            } catch (WrongProductDataException e) {
                                log.error("Wrong date in product to receipt, id: " + r.getProductId());
                            }
                            return null; // TODO: fix it <->
                        }).filter(Objects::nonNull)
                        .toList())
                .stream()
                .map(mapper::mapDaoToReceiptDto)
                .collect(Collectors.toList());
    }


    public List<ReceiptDto> getAll(Pageable pageable) {
        return receiptRepository.findAll(pageable)
                .stream()
                .map(mapper::mapDaoToReceiptDto).collect(Collectors.toList());
    }

    public List<Report> getReport(LocalDate fromDate, LocalDate toDate) {
        return receiptRepository.getSumWeightAndPriceByProvider(fromDate, toDate);
    }


}
