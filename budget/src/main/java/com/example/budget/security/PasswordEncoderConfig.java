// STEP 1: Rename the SecurityConfig class in security package

// File: src/main/java/com/example/budget/security/PasswordEncoderConfig.java
// (Renamed from SecurityConfig.java)
package com.example.budget.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}