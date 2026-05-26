package com.backend.service;

import com.backend.mapper.SaleMapper;
import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.entity.Sale;
import java.util.List;

@Service
@Transactional
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    public SaleResponseDto saveSale(SaleRequestDto saleRequestDto) {
        return saleMapper.toResponseDTO(
                saleRepository.save(
                        saleMapper.toEntity(saleRequestDto)));
    }

    public List<SaleResponseDto> getAllSales() {
        return saleMapper.toResponseDTOList(
                saleRepository.findAll());
    }

    public SaleResponseDto getSaleById(int id) {
        return saleMapper.toResponseDTO(
                saleRepository.findById(id).orElse(null));
    }

    public SaleResponseDto updateSale(int saleNumber, SaleRequestDto dto) {
        Sale sale = saleRepository.findById(saleNumber)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found: " + saleNumber));
        saleMapper.merge(sale, dto);
        return saleMapper.toResponseDTO(saleRepository.save(sale));
    }

    public void deleteSaleById(int id) {
        saleRepository.deleteById(id);
    }
}
