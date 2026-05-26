package com.backend.model.entity;

import com.backend.model.enums.ServiceStatus;
import com.backend.model.enums.ServiceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkOrder {

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
}
