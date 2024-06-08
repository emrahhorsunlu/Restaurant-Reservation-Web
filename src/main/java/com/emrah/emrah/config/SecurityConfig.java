package com.emrah.emrah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer = http.formLogin();
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/index","/about","/contact","/menu","/reservation","/login").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()).csrf().disable();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
