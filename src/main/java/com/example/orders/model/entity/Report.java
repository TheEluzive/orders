package com.example.orders.model.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;



public interface Report {

     Long getProviderId();
     BigDecimal getTotalWeight();
     BigDecimal getTotalPrice();


}
