package com.backend.service;

import com.backend.model.entity.Sale;
import com.backend.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {

        this.saleRepository = saleRepository;

    }

    public void saveSale(Sale sale) {

        saleRepository.save(sale);

    }

    public List<Sale> getAllSales() {

        return saleRepository.findAll();

    }

    public Sale getSaleById(int id) {

        return saleRepository.findById(id).orElse(null);

    }

    public void deleteSaleById(int id){

        saleRepository.deleteById(id);

    }

}
