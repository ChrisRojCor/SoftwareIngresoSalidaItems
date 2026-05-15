package com.backend.mapper;

import com.backend.model.dto.SaleDTO;
import com.backend.model.dto.SaleResponseDTO;
import com.backend.model.entity.Sale;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapper {

    public Sale toEntity(SaleDTO dto) {
        Sale sale = new Sale();
        sale.setAmount(dto.getAmount());
        sale.setDiscount(dto.getDiscount());
        return sale;
    }

    public SaleResponseDTO toResponseDTO(Sale sale) {
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setSaleNumber(sale.getSaleNumber());
        dto.setAmount(sale.getAmount());
        dto.setDiscount(sale.getDiscount());
        dto.setDate(sale.getDate());
        return dto;
    }

    public List<SaleResponseDTO> toResponseDTOList(List<Sale> sales) {
        return sales.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
