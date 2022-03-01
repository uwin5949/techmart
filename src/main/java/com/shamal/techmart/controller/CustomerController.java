package com.shamal.techmart.controller;

import com.shamal.techmart.model.Customer;
import com.shamal.techmart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    private final CustomerService customerService;

    @PostMapping(path = "/add")
    public @ResponseBody Customer addNewUser(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<Customer> getAllUsers() {
        return customerService.getAll();
    }

    @PostMapping(path = "/search/by-email")
    public @ResponseBody Customer searchByEmail(@RequestBody Customer customer) {
        return customerService.getbyEmail(customer.getEmail());
    }

}
