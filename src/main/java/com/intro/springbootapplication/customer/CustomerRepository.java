package com.intro.springbootapplication.customer;

import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getCustomers();
}
