package com.backend.controller;

import com.backend.model.entity.WorkOrder;
import com.backend.service.WorkOrderService;
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
    public void create(@RequestBody WorkOrder workOrder) {
        workOrderService.saveWorkOrder(workOrder);
    }

    @GetMapping
    public List<WorkOrder> read() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public WorkOrder readById(@PathVariable int id) {
        return workOrderService.getWorkOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workOrderService.deleteWorkOrder(id);
    }

    @PutMapping
    public void update(@RequestBody WorkOrder workOrder) {
        workOrderService.saveWorkOrder(workOrder);
    }
}
