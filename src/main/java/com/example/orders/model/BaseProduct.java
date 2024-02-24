package com.example.orders.model;

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
public class BaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @ManyToOne
    private Category category; //todo: new Entity

    private Long weight;

}
