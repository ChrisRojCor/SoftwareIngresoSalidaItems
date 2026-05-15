package com.backend.service;

import com.backend.model.dto.CustomerDTO;
import com.backend.model.dto.CustomerResponseDTO;
import com.backend.mapper.CustomerMapper;
import com.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDTO saveCustomer(CustomerDTO customerDTO) {
        return customerMapper.toResponseDTO(
                customerRepository.save(customerMapper.toEntity(customerDTO)));
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerMapper.toResponseDTOList(
                customerRepository.findAll());
    }

    public CustomerResponseDTO getCustomerById(int id) {
        return customerMapper.toResponseDTO(
                customerRepository.findById(id).orElse(null));
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
