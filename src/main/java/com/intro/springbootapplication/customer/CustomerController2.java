package com.intro.springbootapplication.customer;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v2/customer")
public class CustomerController2 {
    private final CustomerService customerService;

    public CustomerController2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return List.of(new Customer(1L,"JAMES BOND","NO_PASSWORD"));
    }

    @PostMapping("all")
    void registerNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }
@GetMapping(path = "{customerId}")
    Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
}
