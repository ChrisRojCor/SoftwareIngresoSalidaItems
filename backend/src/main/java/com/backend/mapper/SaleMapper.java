package com.backend.mapper;

import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.model.entity.Sale;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapper {

    public Sale toEntity(SaleRequestDto dto) {
        Sale sale = new Sale();
        sale.setAmount(dto.getAmount());
        sale.setDiscount(dto.getDiscount());
        return sale;
    }

    public SaleResponseDto toResponseDTO(Sale sale) {
        SaleResponseDto dto = new SaleResponseDto();
        dto.setSaleNumber(sale.getSaleNumber());
        dto.setAmount(sale.getAmount());
        dto.setDiscount(sale.getDiscount());
        dto.setDate(sale.getDate());
        return dto;
    }

    public void merge(Sale existing, SaleRequestDto dto) {
        existing.setAmount(dto.getAmount());
        existing.setDiscount(dto.getDiscount());
    }

    public List<SaleResponseDto> toResponseDTOList(List<Sale> sales) {
        return sales.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
