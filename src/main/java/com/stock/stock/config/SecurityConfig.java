package com.stock.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(csrf -> csrf.disable())  
            .authorizeHttpRequests(authorize -> 
                authorize
                    .requestMatchers("/api/stocks/**").authenticated() 
                    .anyRequest().permitAll()  
            )
            .cors(withDefaults())
            .httpBasic(withDefaults()); 

        return httpSecurity.build();
    }
}
