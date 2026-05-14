package com.backend.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.backend.model.enums.ServiceType;
import com.backend.model.enums.ServiceStatus;

@Entity
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceNumber;
    @Temporal(TemporalType.DATE)
    private LocalDate date = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private ServiceType type;
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;
    @Column(columnDefinition = "TEXT")
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
