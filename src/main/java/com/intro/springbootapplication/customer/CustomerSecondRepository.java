package com.intro.springbootapplication.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSecondRepository extends JpaRepository<Customer,Long> {
}
