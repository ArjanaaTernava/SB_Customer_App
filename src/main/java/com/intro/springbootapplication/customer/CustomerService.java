package com.intro.springbootapplication.customer;
import com.intro.springbootapplication.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerSecondRepository customerRepository;
    @Autowired
    public CustomerService(CustomerSecondRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        LOGGER.info("Method getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId).orElseThrow(()-> {
            NotFoundException notFoundException = new NotFoundException("Customer" + customerId + "does not exist");
            LOGGER.error("Customer with id {} not found, class: {}", customerId, CustomerService.class, notFoundException);
            return notFoundException;
        });
    }
}
