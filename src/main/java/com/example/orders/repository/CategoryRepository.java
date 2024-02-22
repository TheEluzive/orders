package com.example.orders.repository;

import com.example.orders.model.Category;
import com.example.orders.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findFirstByName(String name);

}
