package com.backend.controller;

import com.backend.model.dto.CustomerRequestDto;
import com.backend.model.dto.CustomerResponseDto;
import com.backend.security.config.Roles;
import com.backend.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@PreAuthorize("hasRole('" + Roles.ADMIN + "') or hasRole('" + Roles.RECEPTIONIST + "')")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDto createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.createCustomer(customerRequestDto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerResponseDto getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.updateCustomer(id, customerRequestDto);
    }
}
