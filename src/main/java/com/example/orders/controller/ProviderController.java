package com.example.orders.controller;

import com.example.orders.model.ProviderRequest;
import com.example.orders.service.ProviderService;
import com.example.orders.model.Provider;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    //todo:: webMessage
    @PostMapping("/register")
    public List<Provider> registerProvider(@RequestBody ProviderRequest request){
        return providerService.registerProvider(request.getProviders());
    }

    @GetMapping("/getAll")
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }


}
