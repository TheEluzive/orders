package com.example.orders.service;

import com.example.orders.model.Category;
import com.example.orders.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getOrAdd(String name) {
        return categoryRepository.findFirstByName(name)
                .orElse(categoryRepository.save(new Category(0L, name)));
    }

}
