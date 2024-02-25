package com.example.orders.service;

import com.example.orders.model.entity.CategoryEntity;
import com.example.orders.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllOrAdd(List<String> names){
        List<CategoryEntity> result = categoryRepository.findAllByNameIsIn(names);

        List<String> toAdd = new ArrayList<>();
        names.forEach(n -> {
            if (result.stream().noneMatch(r -> r.getName().equals(n)))
                toAdd.add(n);
        });
        List<CategoryEntity> categoriesToAdd = toAdd.stream().map(s -> {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setName(s);
            return categoryEntity;
        }).toList();
        List<CategoryEntity> resultAdded = categoryRepository.saveAll(categoriesToAdd);
        result.addAll(resultAdded);
        return result;
    }

}
