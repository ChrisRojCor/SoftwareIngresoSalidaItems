package com.backend.controller;

import com.backend.model.dto.WorkOrderRequestDto;
import com.backend.model.dto.WorkOrderResponseDto;
import com.backend.service.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-orders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @PostMapping
    public WorkOrderResponseDto createWorkOrder(@Valid @RequestBody WorkOrderRequestDto workOrderRequestDto) {
        return workOrderService.createWorkOrder(workOrderRequestDto);
    }

    @GetMapping
    public List<WorkOrderResponseDto> getAllWorkOrders() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public WorkOrderResponseDto getWorkOrderById(@PathVariable int id) {
        return workOrderService.getWorkOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkOrder(@PathVariable Integer id) {
        workOrderService.deleteWorkOrder(id);
    }

    @PutMapping("/{id}")
    public WorkOrderResponseDto updateWorkOrder(@PathVariable int id, @Valid @RequestBody WorkOrderRequestDto workOrderRequestDto) {
        return workOrderService.updateWorkOrder(id, workOrderRequestDto);
    }
}
