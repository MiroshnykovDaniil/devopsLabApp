package com.example.devopslabapp.service;

import com.example.devopslabapp.model.Customer;
import com.example.devopslabapp.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insert(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public Customer getCustomerById(String id){
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }
    @Override
    public void updateCustomer(String id, @NotNull Customer customer){
        Customer customerFromDb = customerRepository.findById(id).get();
        customerFromDb.setFirstName(customer.getFirstName());
        customerFromDb.setLastName(customer.getLastName());
        customerFromDb.setBirthDate(customer.getBirthDate());
        customerRepository.save(customerFromDb);
    }
    @Override
    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

}
