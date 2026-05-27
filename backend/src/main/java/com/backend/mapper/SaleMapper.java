package com.backend.mapper;

import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.model.entity.Sale;
import com.backend.model.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapper {

    private final SaleDetailMapper saleDetailMapper;

    public SaleMapper(SaleDetailMapper saleDetailMapper) {
        this.saleDetailMapper = saleDetailMapper;
    }

    public Sale toEntity(SaleRequestDto dto) {
        Sale sale = new Sale();
        sale.setDiscount(dto.getDiscount());
        sale.setTax(dto.getTax());
        sale.setSubtotal(dto.getSubtotal());
        sale.setTotal(dto.getTotal());
        sale.setPaymentMethod(dto.getPaymentMethod());
        sale.setStatus(dto.getStatus());
        if (dto.getDetails() != null) {
            sale.setDetails(dto.getDetails().stream()
                    .map(detailDto -> {
                        SaleDetail detail = saleDetailMapper.toEntity(detailDto);
                        detail.setSale(sale);
                        return detail;
                    })
                    .collect(Collectors.toList()));
        }
        return sale;
    }

    public SaleResponseDto toResponseDTO(Sale sale) {
        SaleResponseDto dto = new SaleResponseDto();
        dto.setId(sale.getId());
        dto.setCustomerId(sale.getCustomer().getId());
        dto.setSellerId(sale.getSeller().getId());
        dto.setDiscount(sale.getDiscount());
        dto.setTax(sale.getTax());
        dto.setSubtotal(sale.getSubtotal());
        dto.setTotal(sale.getTotal());
        dto.setPaymentMethod(sale.getPaymentMethod());
        dto.setStatus(sale.getStatus());
        dto.setCreatedAt(sale.getCreatedAt());
        if (sale.getDetails() != null) {
            dto.setDetails(sale.getDetails().stream()
                    .map(saleDetailMapper::toResponseDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public void merge(Sale existing, SaleRequestDto dto) {
        existing.setDiscount(dto.getDiscount());
        existing.setTax(dto.getTax());
        existing.setSubtotal(dto.getSubtotal());
        existing.setTotal(dto.getTotal());
        existing.setPaymentMethod(dto.getPaymentMethod());
        existing.setStatus(dto.getStatus());
        if (dto.getDetails() != null) {
            existing.getDetails().clear();
            dto.getDetails().forEach(detailDto -> {
                SaleDetail detail = saleDetailMapper.toEntity(detailDto);
                detail.setSale(existing);
                existing.getDetails().add(detail);
            });
        }
    }

    public List<SaleResponseDto> toResponseDTOList(List<Sale> sales) {
        return sales.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
