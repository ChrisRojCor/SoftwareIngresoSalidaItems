package com.backend.service;

import com.backend.model.entity.OrderService;
import com.backend.repository.OrderServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderService {

    private final OrderServiceRepository orderServiceRepository;


    public ServiceOrderService(OrderServiceRepository orderServiceRepository) {
        this.orderServiceRepository = orderServiceRepository;
    }

    public void saveOrderService(OrderService orderService) {

        orderServiceRepository.save(orderService);
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
