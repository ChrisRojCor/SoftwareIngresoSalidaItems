package com.backend.service;

import com.backend.mapper.WorkOrderMapper;
import com.backend.model.dto.WorkOrderRequestDto;
import com.backend.model.dto.WorkOrderResponseDto;
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

    public void deleteWorkOrder(int id) {
        workOrderRepository.deleteById(id);
    }
}
