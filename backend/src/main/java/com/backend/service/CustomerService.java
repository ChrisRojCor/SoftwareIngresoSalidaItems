package com.backend.service;

import com.backend.model.dto.CustomerRequestDto;
import com.backend.model.dto.CustomerResponseDto;
import com.backend.mapper.CustomerMapper;
import com.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {
        return customerMapper.toResponseDTO(
                customerRepository.save(customerMapper.toEntity(customerRequestDto)));
    }

    public List<CustomerResponseDto> getAllCustomers() {
        return customerMapper.toResponseDTOList(
                customerRepository.findAll());
    }

    public CustomerResponseDto getCustomerById(int id) {
        return customerMapper.toResponseDTO(
                customerRepository.findById(id).orElse(null));
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
