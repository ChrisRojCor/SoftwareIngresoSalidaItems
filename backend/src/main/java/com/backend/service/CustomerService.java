package com.backend.service;

import com.backend.model.entity.Customer;
import com.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;

    }

    public void saveCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();

    }

    public Customer getCustomerById(int id) {

        return customerRepository.findById(id).orElse(null);

    }

    public void deleteCustomerById(int id){

        customerRepository.deleteById(id);

    }

}
