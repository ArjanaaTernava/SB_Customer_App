package com.intro.springbootapplication.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/customer")
@Deprecated
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return List.of(new Customer(1L,"IMPLEMENT DB","NO_PASSWORD", "email@gmail.com"));
    }

    @PostMapping
    void registerNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }
}
