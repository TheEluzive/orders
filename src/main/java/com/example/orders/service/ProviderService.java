package com.example.orders.service;

import com.example.orders.exception.ProviderNotFoundException;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.model.dto.ProviderDto;
import com.example.orders.model.entity.ProviderEntity;
import com.example.orders.model.dto.ProviderRequestDto;
import com.example.orders.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;
    private final OrderMapper mapper;

    public List<ProviderDto> registerProvider(List<ProviderRequestDto> provider){
        List<ProviderEntity> providerEntities = provider.stream()
                .map(providerRequestDto -> ProviderEntity.builder()
                        .name(providerRequestDto.getName())
                        .build())
                .filter(p -> providerRepository.findByName(p.getName()).isEmpty()) //todo: if mistake then ??
                .collect(Collectors.toList());
        return providerRepository.saveAll(providerEntities).stream()
                .map(mapper::mapDaoToProviderDto).collect(Collectors.toList());
    }

    public List<ProviderDto> getAllProviders(){
        return providerRepository.findAll().stream()
                .map(mapper::mapDaoToProviderDto).collect(Collectors.toList());
    }

    public ProviderEntity getProviderById(Long id){
        return providerRepository.findById(id).orElseThrow(ProviderNotFoundException::new);
    }







}
