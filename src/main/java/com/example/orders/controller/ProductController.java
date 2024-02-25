package com.example.orders.controller;

import com.example.orders.model.ProductRequest;
import com.example.orders.model.dto.ProductDto;
import com.example.orders.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDto> getAll( @RequestParam(value = "offset")  Integer offset,
                                    @RequestParam(value = "limit") Integer limit){
        return productService.getAll(PageRequest.of(offset, limit));
    }


    @PostMapping("/register")
    public List<ProductDto> registerProducts(@RequestBody ProductRequest request){
        return productService.register(request.getProviderId(), request.getProducts());
    }

}