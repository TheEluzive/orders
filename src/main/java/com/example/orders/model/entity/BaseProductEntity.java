package com.example.orders.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Table(name = "base_product")
public class BaseProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @ManyToOne
    private CategoryEntity categoryEntity; //todo: new Entity

    private Long weight;

}
