package com.backend.controller;

import com.backend.model.dto.CustomerDTO;
import com.backend.model.dto.CustomerResponseDTO;
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
    public CustomerResponseDTO create(@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping
    public List<CustomerResponseDTO> read() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerResponseDTO readById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping
    public CustomerResponseDTO update(@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }
}
