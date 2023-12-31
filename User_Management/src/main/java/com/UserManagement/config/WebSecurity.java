package com.UserManagement.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurity{

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
         http
        .cors().and()
        .csrf().disable().authorizeHttpRequests()
        .requestMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/signin").loginProcessingUrl("/login").defaultSuccessUrl("/user/").and().csrf().disable();
		return null;
        
    }
}
