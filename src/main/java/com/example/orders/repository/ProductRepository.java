package com.example.orders.repository;

import com.example.orders.model.entity.ProductOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductOfferEntity, Long> {



}
