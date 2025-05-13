package com.healthcare.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/signup")
    public String signUp(@RequestBody String user) {
        // Publish user sign-up event to Kafka
        kafkaProducerService.sendMessage("User signed up: " + user);
        return "User sign-up event published.";
    }
}