package com.backend.service;

import com.backend.mapper.WorkOrderMapper;
import com.backend.model.dto.WorkOrderRequestDto;
import com.backend.model.dto.WorkOrderResponseDto;
import com.backend.repository.WorkOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.entity.WorkOrder;
import java.util.List;

@Service
@Transactional
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final WorkOrderMapper workOrderMapper;

    public WorkOrderService(WorkOrderRepository workOrderRepository, WorkOrderMapper workOrderMapper) {
        this.workOrderRepository = workOrderRepository;
        this.workOrderMapper = workOrderMapper;
    }

    public WorkOrderResponseDto saveWorkOrder(WorkOrderRequestDto workOrderRequestDto) {
        return workOrderMapper.toResponseDTO(
                workOrderRepository.save(
                        workOrderMapper.toEntity(workOrderRequestDto)));
    }

    public List<WorkOrderResponseDto> getAllWorkOrders() {
        return workOrderMapper.toResponseDTOList(
                workOrderRepository.findAll());
    }

    public WorkOrderResponseDto getWorkOrderById(int id) {
        return workOrderMapper.toResponseDTO(
                workOrderRepository.findById(id).orElse(null));
    }

    public WorkOrderResponseDto updateWorkOrder(int serviceNumber, WorkOrderRequestDto dto) {
        WorkOrder workOrder = workOrderRepository.findById(serviceNumber)
                .orElseThrow(() -> new EntityNotFoundException("WorkOrder not found: " + serviceNumber));
        workOrderMapper.merge(workOrder, dto);
        return workOrderMapper.toResponseDTO(workOrderRepository.save(workOrder));
    }

    public void deleteWorkOrder(int id) {
        workOrderRepository.deleteById(id);
    }
}
