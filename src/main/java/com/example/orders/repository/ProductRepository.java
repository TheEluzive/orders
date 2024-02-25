package com.example.orders.repository;

import com.example.orders.model.entity.ProductOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductOfferEntity, Long> {

    public List<ProductOfferEntity> findAllByIdIn(List<Long> ids);

}
