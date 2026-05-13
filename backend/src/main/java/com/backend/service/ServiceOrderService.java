package com.backend.service;

import com.backend.model.entity.OrderService;
import com.backend.repository.orderServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderService {

    private final orderServiceRepository orderServiceRepository;


    public ServiceOrderService(orderServiceRepository orderServiceRepository) {
        this.orderServiceRepository = orderServiceRepository;
    }

    public OrderService saveOrderService(OrderService orderService) {

        return orderServiceRepository.save(orderService);
    }

    public List<OrderService> getAllOrderServices() {
        return orderServiceRepository.findAll();
    }

    public OrderService getOrderServiceById(int id) {
        return orderServiceRepository.findById(id).orElse(null);
    }

    public void deleteOrderService(int id) {
        orderServiceRepository.deleteById(id);
    }
}
