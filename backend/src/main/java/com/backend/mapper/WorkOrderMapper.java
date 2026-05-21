package com.backend.mapper;

import com.backend.model.dto.WorkOrderRequestDto;
import com.backend.model.dto.WorkOrderResponseDto;
import com.backend.model.entity.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkOrderMapper {

    public WorkOrder toEntity(WorkOrderRequestDto dto) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setType(dto.getType());
        workOrder.setStatus(dto.getStatus());
        workOrder.setDiagnosis(dto.getDiagnosis());
        return workOrder;
    }

    public WorkOrderResponseDto toResponseDTO(WorkOrder workOrder) {
        WorkOrderResponseDto dto = new WorkOrderResponseDto();
        dto.setServiceNumber(workOrder.getServiceNumber());
        dto.setDate(workOrder.getDate());
        dto.setType(workOrder.getType());
        dto.setStatus(workOrder.getStatus());
        dto.setDiagnosis(workOrder.getDiagnosis());
        return dto;
    }

    public List<WorkOrderResponseDto> toResponseDTOList(List<WorkOrder> workOrders) {
        return workOrders.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
