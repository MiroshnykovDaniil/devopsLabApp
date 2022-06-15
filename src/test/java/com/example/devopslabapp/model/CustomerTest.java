package com.example.devopslabapp.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.junit.Assert.*;

@SpringBootTest
public class CustomerTest {


    @Test
    public void createCustomerTest(){
        String firstName = "Carl";
        String lastName = "Johnson";
        LocalDate birthDate = LocalDate.of(2000,01,01);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBirthDate(birthDate);

        assertEquals(customer.getBirthDate(),birthDate);
        assertEquals(customer.getFirstName(),firstName);
        assertEquals(customer.getLastName(),lastName);

    }
}
