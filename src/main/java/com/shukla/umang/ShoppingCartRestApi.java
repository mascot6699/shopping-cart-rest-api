package com.shukla.umang;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class ShoppingCartRestApi {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartRestApi.class, args);
    }

    @RequestMapping("/test")
    public String helloGreeting() {
        return "Hello this is test";
    }
}
