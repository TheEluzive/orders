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
                .map(p -> {
                    ProductOffer offer = new ProductOffer();
                    offer.setName(p.getName());
                    offer.setCategory(categoryService.getOrAdd(p.getCategory()));
                    offer.setPrice(p.getPrice());
                    offer.setWeight(p.getWeight());
                    offer.setProvider(provider);
                    offer.setToDate(p.getToDate());
                    offer.setFromDate(p.getFromDate());
                    return offer;
                }
                ).collect(Collectors.toList());
        return productRepository.saveAll(productOfferList);
    }

    public ProductOffer getById(Long id){
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    public List<ProductOffer> getAll() {
        return productRepository.findAll();
    }
}
