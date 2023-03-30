package com.sisiback.api;

import com.sisiback.dao.ServiceDAO;
import com.sisiback.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceAPI {

    @Autowired
    private ServiceDAO serviceDAO;

    @PostMapping("/create")
    public void create(@RequestBody Service service){serviceDAO.save(service);}

    @GetMapping("/read")
    public List<Service> read(){return serviceDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){serviceDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Service service){serviceDAO.save(service);}
}
