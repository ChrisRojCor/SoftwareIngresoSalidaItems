package com.backend.controller;

import com.backend.model.dto.CustomerRequestDto;
import com.backend.model.dto.CustomerResponseDto;
import com.backend.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDto create(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.saveCustomer(customerRequestDto);
    }

    @GetMapping
    public List<CustomerResponseDto> read() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerResponseDto readById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@PathVariable Integer id, @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.updateCustomer(id, customerRequestDto);
    }
}
