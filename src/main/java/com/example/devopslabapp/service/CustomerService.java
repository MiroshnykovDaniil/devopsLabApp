package com.example.devopslabapp.service;


import com.example.devopslabapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer insert(Customer customer);
    public Customer getCustomerById(String id);
    public List<Customer> getCustomers();
    public void updateCustomer(String id, Customer customer);
    public void deleteCustomer(String id);
}
