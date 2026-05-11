package com.backend.controller;

import com.backend.repository.CustomerRepository;
import com.backend.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public void create(@RequestBody Customer customer){customerRepository.save(customer);}

    @GetMapping("/read")
    public List<Customer> read(){return customerRepository.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){customerRepository.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Customer customer){customerRepository.save(customer);}
}
