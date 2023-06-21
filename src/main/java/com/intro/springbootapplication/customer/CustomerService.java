package com.intro.springbootapplication.customer;

import com.intro.springbootapplication.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.getCustomers();
    }

    Customer getCustomerById(Long customerId){
        return getCustomers().stream().filter(customer -> Objects.equals(customer.getId(), customerId)).findFirst().orElseThrow(()-> new NotFoundException("Customer" + customerId + "does not exist"));
    }
}
