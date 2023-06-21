package com.intro.springbootapplication.customer;



import com.intro.springbootapplication.exception.ApiRequestException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path ="api/v2/customer")
public class CustomerController2 {
    private final CustomerService customerService;

    public CustomerController2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("all")
    List<Customer> getCustomers(){
        return List.of(new Customer(1L,"JAMES BOND","NO_PASSWORD", "email@gmail.com"));
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable Long customerId){
        throw new ApiRequestException("API Request Exception for customer" + customerId);
}

    @PostMapping
    void registerNewCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }
    @GetMapping(path = "{customerId}")
    Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    }

