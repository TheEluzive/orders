package com.example.orders.service;

import com.example.orders.model.*;
import com.example.orders.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProviderService providerService;
    private final CategoryService categoryService;

    public List<ProductOffer> register(Long providerId, List<ProductDto> products) {
        Provider provider = providerService.getProviderById(providerId);
        List<ProductOffer> productOfferList = products.stream()
                .map(p -> ProductOffer.builder()
                        .name(p.getName())
                        .category(categoryService.getOrAdd(p.getCategory()))
                        .price(p.getPrice())
                        .weight(p.getWeight())
                        .amount(p.getAmount())
                        .fromDate(p.getFromDate())
                        .toDate(p.getToDate())
                        .provider(provider)
                        .build()
                ).collect(Collectors.toList());
        return productRepository.saveAll(productOfferList);
    }


    public List<ProductOffer> getAll() {
        return productRepository.findAll();
    }
}
