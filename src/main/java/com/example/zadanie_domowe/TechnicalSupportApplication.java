package com.example.zadanie_domowe;

import com.example.zadanie_domowe.model.Customer;
import com.example.zadanie_domowe.model.Employee;
import com.example.zadanie_domowe.model.Registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechnicalSupportApplication {

	public TechnicalSupportApplication(RegistrationService registrationService) {
		Registration registration = registrationService.createRegistration(
				new Customer("Darek", "Kowal"),
				new Employee("Irek", "Hirek"),
				RegistrationStatus.IN_PROGRESS
		);

		System.out.println(registration);

		registrationService.changeRegistrationStatus(registration, RegistrationStatus.COMPLETED);

		System.out.println(registration);

		registrationService.changeRegistrationCustomer(registration, new Customer("Wojtek", "Bebel"));

		System.out.println(registration);

		Registration registrationById = registrationService.getRegistrationByUuid("1");

		System.out.println(registrationById);
	}

	public static void main(String[] args) {
		SpringApplication.run(TechnicalSupportApplication.class, args);
	}
}
