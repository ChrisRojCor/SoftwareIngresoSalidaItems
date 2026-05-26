package com.backend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private String id;
    private String customerName;
    private String businessName;
    private String phone;
    private String contactEmail;
    private String address;
    private String city;
}
