package com.example.zadanie_domowe.model;

import com.example.zadanie_domowe.RegistrationStatus;

import java.util.UUID;

public class Registration {
    private final String uuid;
    private Customer customer;
    private final Employee employee;
    private RegistrationStatus status;

    public Registration(String uuid, Customer customer, Employee employee, RegistrationStatus status) {
        this.uuid = uuid == null ? getRandomUUID() : uuid;
        this.customer = customer;
        this.employee = employee;
        this.status = status;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    public String getRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }

    @Override
    public String toString() {
        return "Registration{" +
                "uuid=" + uuid +
                ", customer=" + customer +
                ", employee=" + employee +
                ", status=" + status +
                '}';
    }
}
