package com.sisiback.dao;

import com.sisiback.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDAO extends JpaRepository<Sale, Integer> {
}
