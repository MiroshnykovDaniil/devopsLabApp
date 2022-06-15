package com.example.devopslabapp.repository;

import com.example.devopslabapp.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void customerInsertTest(){
        Customer customer = new Customer();
        customer.setFirstName("Carl");
        customer.setLastName("Johnson");
        customer.setBirthDate(LocalDate.of(2000,01,01));
        customerRepository.save(customer);
        Assertions.assertEquals(customerRepository.findById(customer.getId()).get(), customer);
        customerRepository.delete(customer);

    }

    @Test
    public void customerDeleteTest(){
        Customer customer = new Customer();
        customerRepository.save(customer);
        customerRepository.delete(customer);
        Assertions.assertTrue(customerRepository.findById(customer.getId()).isEmpty());
    }
}
