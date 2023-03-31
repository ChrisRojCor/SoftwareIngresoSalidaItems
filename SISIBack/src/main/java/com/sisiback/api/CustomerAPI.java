package com.sisiback.api;

import com.sisiback.dao.CustomerDAO;
import com.sisiback.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerAPI {

    @Autowired
    private CustomerDAO customerDAO;

    @PostMapping("/create")
    public void create(@RequestBody Customer customer){customerDAO.save(customer);}

    @GetMapping("/read")
    public List<Customer> read(){
        System.out.println("leyendo clientes de la base de datos");
        return customerDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){customerDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Customer customer){customerDAO.save(customer);}
}
