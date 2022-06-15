package com.example.devopslabapp.service;


import com.example.devopslabapp.model.Customer;
import com.example.devopslabapp.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void getCustomersTest(){
        Customer customer1 = new Customer();
        customer1.setFirstName("name");
        customer1.setLastName("name");
        customer1.setBirthDate(LocalDate.of(2000,01,01));
        Customer customer2 = new Customer();
        customer2.setFirstName("name");
        customer2.setLastName("name");
        customer2.setBirthDate(LocalDate.of(2000,01,01));
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customerRepository.saveAll(customers);

        Assertions.assertTrue(customerService.getCustomers().containsAll(customers));
        customerRepository.deleteAll(customers);

    }
}
