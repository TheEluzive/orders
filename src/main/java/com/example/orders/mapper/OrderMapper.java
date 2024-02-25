package com.example.orders.mapper;

import com.example.orders.model.dto.ProductDto;
import com.example.orders.model.dto.ProductRequestDto;
import com.example.orders.model.dto.ProviderDto;
import com.example.orders.model.dto.ReceiptDto;
import com.example.orders.model.entity.CategoryEntity;
import com.example.orders.model.entity.ProductOfferEntity;
import com.example.orders.model.entity.ProviderEntity;
import com.example.orders.model.entity.ReceiptEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    public ProductOfferEntity mapDtoToProductOffer(ProviderEntity providerEntity, ProductRequestDto products, List<CategoryEntity> categories) {
        ProductOfferEntity offer = new ProductOfferEntity();
        offer.setName(products.getName());
        offer.setCategoryEntity(categories.stream()
                .filter(c-> !c.getName().equals(products.getCategory()))
                .findFirst().orElseThrow(RuntimeException::new));
        offer.setPrice(products.getPrice());
        offer.setWeight(products.getWeight());
        offer.setProviderEntity(providerEntity);
        offer.setToDate(products.getToDate());
        offer.setFromDate(products.getFromDate());
        return offer;
    }

    public ProductDto mapDaoToProductDto(ProviderEntity providerEntity, ProductOfferEntity productOffers) {
        ProductDto dto = mapDaoToProductDto(productOffers);
        if (Objects.nonNull(providerEntity))
            dto.setProviderEntity(providerEntity);
        dto.setProviderEntity(productOffers.getProviderEntity());
        return dto;
    }
    public ProductDto mapDaoToProductDto(ProductOfferEntity productOffers) {
        ProductDto dto = new ProductDto();
        dto.setId(productOffers.getId());
        dto.setName(productOffers.getName());
        dto.setCategoryEntity(productOffers.getCategoryEntity());
        dto.setWeight(productOffers.getWeight());
        dto.setPrice(productOffers.getPrice());
        dto.setFromDate(productOffers.getFromDate());
        dto.setToDate(productOffers.getToDate());
        dto.setProviderEntity(productOffers.getProviderEntity());
        return dto;
    }

    public ProviderDto mapDaoToProviderDto(ProviderEntity providerEntity){
        ProviderDto providerDto = new ProviderDto();
        providerDto.setId(providerEntity.getId());
        providerDto.setName(providerEntity.getName());
        return providerDto;
    }

    public ReceiptDto mapDaoToReceiptDto(ReceiptEntity entity) {
        ReceiptDto dto = new ReceiptDto();
        dto.setAmount(entity.getAmount());
        dto.setProductDto(mapDaoToProductDto(entity.getProduct()));
        return dto;
    }
}
