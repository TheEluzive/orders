package com.example.orders.repository;

import com.example.orders.model.entity.ReceiptEntity;
import com.example.orders.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Long> {

    @Query(nativeQuery = true, value = "select\n" +
            "    provider_entity_id as providerId, sum(base.weight) as totalWeight, sum(price) as totalPrice\n" +
            "from (select id, amount, product_id, date_receipt  from receipt where receipt.date_receipt between :fromDate AND :toDate) as receipt\n" +
            "left join product_offer as product on receipt.product_id = product.id\n" +
            "left join base_product as base on receipt.product_id = base.id\n" +
            "group by provider_entity_id;")
    List<Report> getSumWeightAndPriceByProvider(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);




}
