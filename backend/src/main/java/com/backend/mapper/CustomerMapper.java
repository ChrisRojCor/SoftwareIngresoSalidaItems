package com.backend.mapper;

import com.backend.model.dto.CustomerDTO;
import com.backend.model.dto.CustomerResponseDTO;
import com.backend.model.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setCustomerName(dto.getCustomerName());
        customer.setBusinessName(dto.getBusinessName());
        customer.setPhone(dto.getPhone());
        customer.setContactEmail(dto.getContactEmail());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        return customer;
    }

    public CustomerResponseDTO toResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setCustomerName(customer.getCustomerName());
        dto.setBusinessName(customer.getBusinessName());
        dto.setPhone(customer.getPhone());
        dto.setContactEmail(customer.getContactEmail());
        dto.setAddress(customer.getAddress());
        dto.setCity(customer.getCity());
        return dto;
    }

    public List<CustomerResponseDTO> toResponseDTOList(List<Customer> customers) {
        return customers.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
