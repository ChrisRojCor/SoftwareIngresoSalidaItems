package com.backend.controller;

import com.backend.model.entity.OrderService;
import com.backend.service.ServiceOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("service")
public class orderServiceController {

    private final ServiceOrderService serviceOrderService;

    public orderServiceController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @PostMapping
    public void create(@RequestBody OrderService orderService) {
        serviceOrderService.saveOrderService(orderService);
    }

    @GetMapping
    public List<OrderService> read() {
        return serviceOrderService.getAllOrderServices();
    }

    @GetMapping("/{id}")
    public OrderService readById(@PathVariable int id) {
        return serviceOrderService.getOrderServiceById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        serviceOrderService.deleteOrderService(id);
    }

    @PutMapping
    public void update(@RequestBody OrderService orderService) {
        serviceOrderService.saveOrderService(orderService);
    }
}
