package com.example.zadanie_domowe;

import com.example.zadanie_domowe.model.Registration;
import com.example.zadanie_domowe.storage.RegistrationStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegistrationServiceIntegrationTest {

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private RegistrationStorage registrationStorage;

    @Test
    void changeRegistrationStatus() {
        //given
        Registration registration = new Registration(null, null, null, RegistrationStatus.IN_PROGRESS);
        when(registrationStorage.getRegistrationByUuid(any())).thenReturn(registration);

        //when
        Registration testRegistration = registrationService.changeRegistrationStatus(registration, RegistrationStatus.CANCELED);

        //then
        assertThat(testRegistration).isInstanceOf(Registration.class);
    }

    @Test
    void changeRegistrationCustomer() {
        //given
        Registration registration = new Registration(null, null, null, RegistrationStatus.IN_PROGRESS);
        when(registrationStorage.getRegistrationByUuid(any())).thenReturn(registration);

        //when
        registrationService.changeRegistrationCustomer(registration, null);

        //then
        assertThat(registration).isNotNull();
    }

    @Test
    void getRegistrationByUuid() {
        //given
        Registration registration = new Registration(null, null, null, RegistrationStatus.IN_PROGRESS);
        when(registrationStorage.getRegistrationByUuid(any())).thenReturn(null);

        //when
        Registration testRegistration = registrationService.getRegistrationByUuid(registration.getUuid());

        //then
        assertThat(testRegistration).isNull();
    }
}