package com.example.devopslabapp.repository;

import com.example.devopslabapp.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String> {


}
