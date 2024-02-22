package com.example.orders.repository;

import com.example.orders.model.ProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductOffer, Long> {



}
