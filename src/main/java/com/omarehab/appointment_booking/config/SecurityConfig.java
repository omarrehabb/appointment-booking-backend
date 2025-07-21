package com.omarehab.appointment_booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          // turn off CSRF so POST/PUT/DELETE work easily in Postman/Angular
          .csrf(csrf -> csrf.disable())

          // open up all API endpoints
          .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/**").permitAll()
            .anyRequest().authenticated()
          )

          // keep HTTP Basic for non-API (if you use any other endpoints)
          .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
