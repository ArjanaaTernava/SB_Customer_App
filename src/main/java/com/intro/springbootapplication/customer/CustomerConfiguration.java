package com.intro.springbootapplication.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${useFakeCustomerRepo}")
    private boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("hello from customer configuration");
        };
    }

    @Bean
    CustomerRepository customerRepository(){
        System.out.println("useFakeCustomerRepo" + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerImplFake() : new CustomerImpl();
    }
}
