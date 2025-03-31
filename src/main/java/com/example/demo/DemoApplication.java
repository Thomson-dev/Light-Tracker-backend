package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//// Define a separate controller class
//@RestController
//class HelloController {
//
//    // This method handles HTTP GET requests to /hello
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello, World!";
//    }
//}