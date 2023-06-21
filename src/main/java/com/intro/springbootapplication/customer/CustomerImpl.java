package com.intro.springbootapplication.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

public class CustomerImpl implements CustomerRepository{

    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }
}
