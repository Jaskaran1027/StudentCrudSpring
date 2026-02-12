package com.example.student.StudentRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").permitAll().anyRequest().authenticated()).formLogin(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults()).csrf(csrf -> csrf.disable()) ;
        return http.build();
    }

}
