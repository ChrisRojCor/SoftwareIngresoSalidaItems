package com.backend.repository;

import com.backend.model.entity.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderServiceRepository extends JpaRepository<OrderService, Integer> {
}
