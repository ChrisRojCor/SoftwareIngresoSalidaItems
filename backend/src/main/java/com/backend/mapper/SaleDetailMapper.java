package com.backend.mapper;

import com.backend.model.dto.SaleDetailRequestDto;
import com.backend.model.dto.SaleDetailResponseDto;
import com.backend.model.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleDetailMapper {

    public SaleDetail toEntity(SaleDetailRequestDto dto) {
        SaleDetail detail = new SaleDetail();
        detail.setItemDescription(dto.getItemDescription());
        detail.setQuantity(dto.getQuantity());
        detail.setUnitPrice(dto.getUnitPrice());
        detail.setLineTotal(dto.getUnitPrice().multiply(BigDecimal.valueOf(dto.getQuantity())));
        return detail;
    }

    public SaleDetailResponseDto toResponseDTO(SaleDetail detail) {
        SaleDetailResponseDto dto = new SaleDetailResponseDto();
        dto.setId(detail.getId());
        dto.setItemDescription(detail.getItemDescription());
        dto.setQuantity(detail.getQuantity());
        dto.setUnitPrice(detail.getUnitPrice());
        dto.setLineTotal(detail.getLineTotal());
        return dto;
    }

    public void merge(SaleDetail existing, SaleDetailRequestDto dto) {
        existing.setItemDescription(dto.getItemDescription());
        existing.setQuantity(dto.getQuantity());
        existing.setUnitPrice(dto.getUnitPrice());
        existing.setLineTotal(dto.getUnitPrice().multiply(BigDecimal.valueOf(dto.getQuantity())));
    }

    public List<SaleDetailResponseDto> toResponseDTOList(List<SaleDetail> details) {
        return details.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
