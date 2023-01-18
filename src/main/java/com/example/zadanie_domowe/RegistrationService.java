package com.example.zadanie_domowe;

import com.example.zadanie_domowe.model.Customer;
import com.example.zadanie_domowe.model.Employee;
import com.example.zadanie_domowe.model.Registration;
import com.example.zadanie_domowe.storage.RegistrationStorage;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private final RegistrationStorage registrationStorage;

    public RegistrationService(RegistrationStorage registrationStorage) {
        this.registrationStorage = registrationStorage;
    }

    public Registration createRegistration(Customer customer, Employee employee, RegistrationStatus status) {
        Registration newRegistration = new Registration(null, customer, employee, status);

        registrationStorage.addNewRegistration(newRegistration);

        return newRegistration;
    }

    public Registration changeRegistrationStatus(Registration registration, RegistrationStatus status) {
        Registration searchedRegistration = registrationStorage.getRegistrationByUuid(registration.getUuid());

        if (searchedRegistration == null) return null;

        registrationStorage.changeRegistrationStatus(searchedRegistration, status);

        return searchedRegistration;
    }

    public void changeRegistrationCustomer(Registration registration, Customer customer) {
        Registration searchedRegistration = registrationStorage.getRegistrationByUuid(registration.getUuid());

        if (searchedRegistration == null) return;

        registrationStorage.changeRegistrationCustomer(searchedRegistration, customer);
    }

    public Registration getRegistrationByUuid(String uuid) {
        return registrationStorage.getRegistrationByUuid(uuid);
    }
}
