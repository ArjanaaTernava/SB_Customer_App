package com.intro.springbootapplication.customer;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerImplFake implements CustomerRepository{
    @Override
    public List<Customer> getCustomer() {
        return List.of(new Customer(1L,"JOHN"), new Customer(2L,"MARY"));
    }
}
