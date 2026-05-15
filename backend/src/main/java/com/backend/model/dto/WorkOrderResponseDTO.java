package com.backend.model.dto;

import com.backend.model.enums.ServiceStatus;
import com.backend.model.enums.ServiceType;

import java.time.LocalDate;

public class WorkOrderResponseDTO {

    private int serviceNumber;
    private LocalDate date;
    private ServiceType type;
    private ServiceStatus status;
    private String diagnosis;

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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
