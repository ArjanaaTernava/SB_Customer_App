package com.intro.springbootapplication.jsonPlaceHolder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceHolderConfiguration {
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JsonPlaceHolderClient jsonPlaceHolderClient){
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/posts is called");
            System.out.println(jsonPlaceHolderClient.getPosts().size());
            System.out.println("https://jsonplaceholder.typicode.com/posts/1 is called");
            System.out.println(jsonPlaceHolderClient.getPost(1));
        };
    }

}
