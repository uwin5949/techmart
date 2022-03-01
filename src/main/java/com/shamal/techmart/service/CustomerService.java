package com.shamal.techmart.service;


import com.shamal.techmart.model.Customer;
import com.shamal.techmart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final CustomerRepository customerRepository;


    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getbyEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public Customer save(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

}
