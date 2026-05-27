package com.backend.service;

import com.backend.mapper.SaleMapper;
import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.model.entity.Customer;
import com.backend.model.entity.Sale;
import com.backend.model.entity.User;
import com.backend.repository.CustomerRepository;
import com.backend.repository.SaleRepository;
import com.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository,
                       CustomerRepository customerRepository,
                       UserRepository userRepository,
                       SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.saleMapper = saleMapper;
    }

    public SaleResponseDto createSale(SaleRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found: " + dto.getCustomerId()));
        User seller = userRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.getSellerId()));
        Sale sale = saleMapper.toEntity(dto);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        return saleMapper.toResponseDTO(saleRepository.save(sale));
    }

    public List<SaleResponseDto> getAllSales() {
        return saleMapper.toResponseDTOList(saleRepository.findAll());
    }

    public SaleResponseDto getSaleById(int id) {
        return saleMapper.toResponseDTO(
                saleRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Sale not found: " + id)));
    }

    public SaleResponseDto updateSale(int id, SaleRequestDto dto) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found: " + id));
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found: " + dto.getCustomerId()));
        User seller = userRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.getSellerId()));
        saleMapper.merge(sale, dto);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        return saleMapper.toResponseDTO(saleRepository.save(sale));
    }

    public void deleteSaleById(int id) {
        saleRepository.deleteById(id);
    }
}
