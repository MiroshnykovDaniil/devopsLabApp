package com.example.devopslabapp.controller;


import com.example.devopslabapp.model.Customer;
import com.example.devopslabapp.service.CustomerService;
import com.example.devopslabapp.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/",produces = "application/json")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id){
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/",produces = "application/json")
    public ResponseEntity<Customer> insert(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.insert(customer),HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }

}
