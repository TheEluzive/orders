package com.example.orders.repository;

import com.example.orders.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findFirstByName(String name);

    List<CategoryEntity> findAllByNameIsIn(List<String> names);

}
