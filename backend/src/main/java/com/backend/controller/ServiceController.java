package com.backend.controller;

import com.backend.repository.ServiceRepository;
import com.backend.model.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/create")
    public void create(@RequestBody Service service){serviceRepository.save(service);}

    @GetMapping("/read")
    public List<Service> read(){return serviceRepository.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){serviceRepository.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Service service){serviceRepository.save(service);}
}
