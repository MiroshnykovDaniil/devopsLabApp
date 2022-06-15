package com.example.devopslabapp.service;


import com.example.devopslabapp.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer insert(Customer customer);
    Customer getCustomerById(String id);
    List<Customer> getCustomers();
    void updateCustomer(String id, Customer customer);
    void deleteCustomer(String id);
}
