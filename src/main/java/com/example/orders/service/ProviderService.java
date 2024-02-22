package com.example.orders.service;

import com.example.orders.exception.ProviderNotFoundException;
import com.example.orders.model.Provider;
import com.example.orders.model.ProviderDto;
import com.example.orders.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;

    public List<Provider> registerProvider(List<ProviderDto> provider){
        List<Provider> providers = provider.stream()
                .map(providerDto -> Provider.builder()
                        .name(providerDto.getName())
                        .build())
                .filter(p -> providerRepository.findByName(p.getName()).isEmpty()) //todo: if mistake then ??
                .collect(Collectors.toList());
        return providerRepository.saveAll(providers);
    }

    public List<Provider> getAllProviders(){
        return providerRepository.findAll();
    }

    public Provider getProviderById(Long id){
        return providerRepository.findById(id).orElseThrow(ProviderNotFoundException::new);
    }



}
