package com.backend.model.dto;

import com.backend.model.enums.ServiceStatus;
import com.backend.model.enums.ServiceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WorkOrderRequestDto {

    @NotNull
    private ServiceType type;

    @NotNull
    private ServiceStatus status;

    @Size(max = 2000)
    private String diagnosis;
}
