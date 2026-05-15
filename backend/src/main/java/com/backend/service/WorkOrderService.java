package com.backend.service;

import com.backend.mapper.WorkOrderMapper;
import com.backend.model.dto.WorkOrderDTO;
import com.backend.model.dto.WorkOrderResponseDTO;
import com.backend.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final WorkOrderMapper workOrderMapper;

    public WorkOrderService(WorkOrderRepository workOrderRepository, WorkOrderMapper workOrderMapper) {
        this.workOrderRepository = workOrderRepository;
        this.workOrderMapper = workOrderMapper;
    }

    public WorkOrderResponseDTO saveWorkOrder(WorkOrderDTO workOrderDTO) {
        return workOrderMapper.toResponseDTO(
                workOrderRepository.save(
                        workOrderMapper.toEntity(workOrderDTO)));
    }

    public List<WorkOrderResponseDTO> getAllWorkOrders() {
        return workOrderMapper.toResponseDTOList(
                workOrderRepository.findAll());
    }

    public WorkOrderResponseDTO getWorkOrderById(int id) {
        return workOrderMapper.toResponseDTO(
                workOrderRepository.findById(id).orElse(null));
    }

    public void deleteWorkOrder(int id) {
        workOrderRepository.deleteById(id);
    }
}
