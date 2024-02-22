package com.example.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
public class Provider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "provider")
    @JsonIgnore
    private List<ProductOffer> productOfferList;
}
