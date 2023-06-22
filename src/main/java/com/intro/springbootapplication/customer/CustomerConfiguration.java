package com.intro.springbootapplication.customer;
import com.intro.springbootapplication.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${useFakeCustomerRepo}")
    private boolean useFakeCustomerRepo;

    @Autowired
    private Environment environment;
    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("hello from customer configuration");
            System.out.println(environment.getProperty("useFakeCustomerRepo"));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepository customerRepository(){
        return new CustomerImplFake() ;
    }
}
