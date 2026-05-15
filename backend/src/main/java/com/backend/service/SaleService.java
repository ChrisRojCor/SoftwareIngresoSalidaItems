package com.backend.service;

import com.backend.mapper.SaleMapper;
import com.backend.model.dto.SaleDTO;
import com.backend.model.dto.SaleResponseDTO;
import com.backend.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    public SaleResponseDTO saveSale(SaleDTO saleDTO) {
        return saleMapper.toResponseDTO(
                saleRepository.save(
                        saleMapper.toEntity(saleDTO)));
    }

    public List<SaleResponseDTO> getAllSales() {
        return saleMapper.toResponseDTOList(
                saleRepository.findAll());
    }

    public SaleResponseDTO getSaleById(int id) {
        return saleMapper.toResponseDTO(
                saleRepository.findById(id).orElse(null));
    }

    public void deleteSaleById(int id) {
        saleRepository.deleteById(id);
    }
}
