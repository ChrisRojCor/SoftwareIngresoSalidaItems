package com.sisiback.api;

import com.sisiback.dao.SaleDAO;
import com.sisiback.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleAPI {

    @Autowired
    private SaleDAO saleDAO;

    @PostMapping("/create")
    public void create(@RequestBody Sale sale){saleDAO.save(sale);}

    @GetMapping("/read")
    public List<Sale> read(){return saleDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){saleDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Sale sale){saleDAO.save(sale);}
}
