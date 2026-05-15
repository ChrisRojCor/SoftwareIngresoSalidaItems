package com.backend.mapper;

import com.backend.model.dto.WorkOrderDTO;
import com.backend.model.dto.WorkOrderResponseDTO;
import com.backend.model.entity.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkOrderMapper {

    public WorkOrder toEntity(WorkOrderDTO dto) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setType(dto.getType());
        workOrder.setStatus(dto.getStatus());
        workOrder.setDiagnosis(dto.getDiagnosis());
        return workOrder;
    }

    public WorkOrderResponseDTO toResponseDTO(WorkOrder workOrder) {
        WorkOrderResponseDTO dto = new WorkOrderResponseDTO();
        dto.setServiceNumber(workOrder.getServiceNumber());
        dto.setDate(workOrder.getDate());
        dto.setType(workOrder.getType());
        dto.setStatus(workOrder.getStatus());
        dto.setDiagnosis(workOrder.getDiagnosis());
        return dto;
    }

    public List<WorkOrderResponseDTO> toResponseDTOList(List<WorkOrder> workOrders) {
        return workOrders.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
