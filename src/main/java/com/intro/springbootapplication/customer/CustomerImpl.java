package com.intro.springbootapplication.customer;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CustomerImpl implements CustomerRepository{

    @Override
    public List<Customer> getCustomer() {
        return Collections.emptyList();
    }
}
