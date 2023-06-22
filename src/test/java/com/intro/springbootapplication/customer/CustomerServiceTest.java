package com.intro.springbootapplication.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerSecondRepository customerSecondRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp(){
        underTest = new CustomerService(customerSecondRepository);
    }

    @AfterEach
    void tearDown(){
        customerSecondRepository.deleteAll();
    }

    @Test
    void getCustomers(){
        Customer enis = new Customer(1L,"Enis","123","enis@gmail.com");
        Customer denis = new Customer(2L,"Denis","123","denis@gmail.com");

        customerSecondRepository.saveAll(List.of(enis,denis));

        List<Customer>customers = underTest.getCustomers();

        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer(){
        Customer enis = new Customer(1L,"Enis","123","enis@gmail.com");
        customerSecondRepository.save(enis);

        Customer customer = underTest.getCustomerById(1L);
        assertEquals(1L,customer.getId());
        assertEquals("Enis",customer.getName());
        assertEquals("123",customer.getPassword());
        assertEquals("enis@gmail.com",customer.getEmail());
    }


}
