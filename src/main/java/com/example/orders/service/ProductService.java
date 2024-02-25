package com.example.orders.service;

import com.example.orders.mapper.OrderMapper;
import com.example.orders.model.dto.ProductDto;
import com.example.orders.model.dto.ProductRequestDto;
import com.example.orders.model.entity.CategoryEntity;
import com.example.orders.model.entity.ProductOfferEntity;
import com.example.orders.model.entity.ProviderEntity;
import com.example.orders.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProviderService providerService;
    private final CategoryService categoryService;
    private final OrderMapper mapper;

    public List<ProductDto> register(Long providerId, List<ProductRequestDto> products) {
        ProviderEntity providerEntity = providerService.getProviderById(providerId);

        List<String> categoriesName = new ArrayList<>();
        products.forEach(s -> categoriesName.add(s.getName()));
        List<CategoryEntity> categories =  categoryService.getAllOrAdd(categoriesName);

        List<ProductOfferEntity> offersToRegister = products.stream()
                .map(p -> mapper.mapDtoToProductOffer(providerEntity, p, categories))
                .toList();
        List<ProductOfferEntity> result = productRepository.saveAll(offersToRegister);

        return result.stream()
                .map(p -> mapper.mapDaoToProductDto(providerEntity, p))
                .collect(Collectors.toList());
    }

    public ProductDto getById(Long id) {
        return mapper.mapDaoToProductDto(productRepository.findById(id).orElseThrow(RuntimeException::new));
    }


    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> mapper.mapDaoToProductDto(null, p))
                .collect(Collectors.toList());
    }


}