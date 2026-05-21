package com.backend.model.dto;

import com.backend.model.enums.ServiceStatus;
import com.backend.model.enums.ServiceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WorkOrderRequestDto {

    @NotNull
    private ServiceType type;

    @NotNull
    private ServiceStatus status;

    @Size(max = 2000)
    private String diagnosis;

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
