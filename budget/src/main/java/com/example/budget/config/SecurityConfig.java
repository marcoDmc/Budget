package com.example.budget.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Configuração de segurança
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for API requests
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/v1/user/**").permitAll() // Allow public access to all v1/user/* routes
                        .requestMatchers("/public/**").permitAll() // Allow public access to these routes
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Only users with admin role
                        .requestMatchers("/v1/account/**").permitAll() // UPDATED: Allow public access to account routes
                        .requestMatchers("/account/**").permitAll() // UPDATED: Allow public access to account routes
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated() // Any other request requires authentication
                )
                .httpBasic(Customizer.withDefaults()) // Enable HTTP Basic authentication for APIs
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .disable() // Disable default form login - optional if you don't want redirection
                );
        return http.build();
    }
}
