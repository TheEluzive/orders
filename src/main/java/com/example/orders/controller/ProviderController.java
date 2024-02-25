package com.example.orders.controller;

import com.example.orders.model.ProviderRequest;
import com.example.orders.model.dto.ProviderDto;
import com.example.orders.service.ProviderService;
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
    public List<ProviderDto> registerProvider(@RequestBody ProviderRequest request){
        return providerService.registerProvider(request.getProviders());
    }

    @GetMapping("/getAll")
    public List<ProviderDto> getAllProviders(){
        return providerService.getAllProviders();
    }


}
