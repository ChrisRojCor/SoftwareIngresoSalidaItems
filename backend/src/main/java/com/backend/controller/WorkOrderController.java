package com.backend.controller;

import com.backend.model.dto.WorkOrderDTO;
import com.backend.model.dto.WorkOrderResponseDTO;
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
    public WorkOrderResponseDTO create(@Valid @RequestBody WorkOrderDTO workOrderDTO) {
        return workOrderService.saveWorkOrder(workOrderDTO);
    }

    @GetMapping
    public List<WorkOrderResponseDTO> read() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public WorkOrderResponseDTO readById(@PathVariable int id) {
        return workOrderService.getWorkOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workOrderService.deleteWorkOrder(id);
    }

    @PutMapping
    public WorkOrderResponseDTO update(@Valid @RequestBody WorkOrderDTO workOrderDTO) {
        return workOrderService.saveWorkOrder(workOrderDTO);
    }
}
