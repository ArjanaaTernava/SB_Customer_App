package com.intro.springbootapplication.customer;
import com.intro.springbootapplication.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    private final CustomerSecondRepository customerRepository;

    public CustomerService(CustomerSecondRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomerById(Long customerId){
        return getCustomers().stream().filter(customer -> Objects.equals(customer.getId(), customerId)).findFirst().orElseThrow(()-> new NotFoundException("Customer" + customerId + "does not exist"));
    }
}
