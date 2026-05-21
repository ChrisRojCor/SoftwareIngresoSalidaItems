package com.backend.controller;

import com.backend.model.dto.WorkOrderRequestDto;
import com.backend.model.dto.WorkOrderResponseDto;
import com.backend.service.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("work-orders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @PostMapping
    public WorkOrderResponseDto create(@Valid @RequestBody WorkOrderRequestDto workOrderRequestDto) {
        return workOrderService.saveWorkOrder(workOrderRequestDto);
    }

    @GetMapping
    public List<WorkOrderResponseDto> read() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public WorkOrderResponseDto readById(@PathVariable int id) {
        return workOrderService.getWorkOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workOrderService.deleteWorkOrder(id);
    }

    @PutMapping
    public WorkOrderResponseDto update(@Valid @RequestBody WorkOrderRequestDto workOrderRequestDto) {
        return workOrderService.saveWorkOrder(workOrderRequestDto);
    }
}
