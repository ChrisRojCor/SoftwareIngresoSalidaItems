package com.backend.service;

import com.backend.model.entity.WorkOrder;
import com.backend.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderService(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    public void saveWorkOrder(WorkOrder workOrder) {
        workOrderRepository.save(workOrder);
    }

    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }

    public WorkOrder getWorkOrderById(int id) {
        return workOrderRepository.findById(id).orElse(null);
    }

    public void deleteWorkOrder(int id) {
        workOrderRepository.deleteById(id);
    }
}
