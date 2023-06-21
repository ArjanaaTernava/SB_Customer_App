package com.intro.springbootapplication.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {
    private final Long id;
    @NotBlank
    @NotBlank(message = "Name is required")
    private final String name;
  // @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private final String password;

    @NotBlank(message = "Email is required")
    @Email
    private final String email;

    Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

