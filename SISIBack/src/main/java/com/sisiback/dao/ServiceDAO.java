package com.sisiback.dao;

import com.sisiback.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDAO extends JpaRepository<Service, Integer> {
}
