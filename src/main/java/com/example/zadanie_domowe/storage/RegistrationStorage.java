package com.example.zadanie_domowe.storage;

import com.example.zadanie_domowe.RegistrationStatus;
import com.example.zadanie_domowe.model.Customer;
import com.example.zadanie_domowe.model.Employee;
import com.example.zadanie_domowe.model.Registration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationStorage {
    private final List<Registration> registrationList = new ArrayList<>();

    public RegistrationStorage() {
        this.registrationList.addAll(List.of(
            new Registration(null, new Customer("Darek", "Tester"), new Employee("Marek", "Kowalski"), RegistrationStatus.COMPLETED),
            new Registration("1", new Customer("Irek", "Kowal"), new Employee("Mietek", "Bednar"), RegistrationStatus.CANCELED),
            new Registration(null, new Customer("Wojtek", "Spych"), new Employee("Tomek", "Rampa"), RegistrationStatus.IN_PROGRESS)
        ));
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public Registration getRegistrationByUuid(String registrationId) {
        for (Registration registration : getRegistrationList()) {
            if (registration.getUuid().equals(registrationId)) {
                return registration;
            }
        }

        return null;
    }

    public void addNewRegistration(Registration registration) {
        this.registrationList.add(registration);
    }

    public void changeRegistrationStatus(Registration registration, RegistrationStatus status) {
        registration.setStatus(status);
    }

    public void changeRegistrationCustomer(Registration registration, Customer customer) {
        registration.setCustomer(customer);
    }
}
