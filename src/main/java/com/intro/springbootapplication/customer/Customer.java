package com.intro.springbootapplication.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor

@RequiredArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@Table(name = "customers")
public class Customer {
    @Id
    private Long id;
    @NotBlank
    @NotBlank(message = "Name is required")
    private  String name;
  // @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private  String password;

    @NotBlank(message = "Email is required")
    @Email
    private  String email;



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

