package com.sisiback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    private String id;
    private String customerName;
    private String businessName;
    private String taxpayerType;
    private String ciiu;
    private String phone;
    private String contactEmail;
    private String billingEmail;
    private String address;
    private String city;
    private String department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getCiiu() {
        return ciiu;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", taxpayerType='" + taxpayerType + '\'' +
                ", ciiu='" + ciiu + '\'' +
                ", phone=" + phone +
                ", contactEmail='" + contactEmail + '\'' +
                ", billingEmail='" + billingEmail + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
