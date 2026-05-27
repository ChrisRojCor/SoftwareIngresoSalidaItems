package com.backend.mapper;

import com.backend.model.dto.CustomerRequestDto;
import com.backend.model.dto.CustomerResponseDto;
import com.backend.model.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setCustomerName(dto.getCustomerName());
        customer.setBusinessName(dto.getBusinessName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        return customer;
    }

    public CustomerResponseDto toResponseDTO(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setId(customer.getId());
        dto.setCustomerName(customer.getCustomerName());
        dto.setBusinessName(customer.getBusinessName());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        dto.setCity(customer.getCity());
        dto.setCreatedAt(customer.getCreatedAt());
        return dto;
    }

    public void merge(Customer existing, CustomerRequestDto dto) {
        existing.setCustomerName(dto.getCustomerName());
        existing.setBusinessName(dto.getBusinessName());
        existing.setPhone(dto.getPhone());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());
        existing.setCity(dto.getCity());
    }

    public List<CustomerResponseDto> toResponseDTOList(List<Customer> customers) {
        return customers.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
