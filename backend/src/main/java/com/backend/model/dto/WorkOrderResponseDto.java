package com.backend.model.dto;

import com.backend.model.enums.ServiceStatus;
import com.backend.model.enums.ServiceType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkOrderResponseDto {

    private int serviceNumber;
    private LocalDate date;
    private ServiceType type;
    private ServiceStatus status;
    private String diagnosis;
}
