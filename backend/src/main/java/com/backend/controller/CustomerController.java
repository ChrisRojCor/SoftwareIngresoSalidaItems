package com.backend.controller;

import com.backend.model.entity.Customer;
import com.backend.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){

        this.customerService = customerService;

    }

    @PostMapping
    public void create(@RequestBody Customer customer){customerService.saveCustomer(customer);}

    @GetMapping
    public List<Customer> read(){return customerService.getAllCustomers();}

    @GetMapping("{id}")
    public Customer readById(@PathVariable Integer id){return customerService.getCustomerById(id);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){customerService.deleteCustomerById(id);}

    @PutMapping
    public void update(@RequestBody Customer customer){customerService.saveCustomer(customer);}
}
