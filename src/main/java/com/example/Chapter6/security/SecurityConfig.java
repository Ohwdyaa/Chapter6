package com.example.Chapter6.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/signup").permitAll() // Endpoint pendaftaran dapat diakses tanpa otentikasi
                .antMatchers("/customer/**").hasRole("CUSTOMER") // Endpoint khusus CUSTOMER
                .antMatchers("/merchant/**").hasRole("MERCHANT") // Endpoint khusus MERCHANT
                .anyRequest().authenticated() // Semua endpoint lain memerlukan otentikasi
                .and()
                .formLogin()
                .loginPage("/login") // Halaman login kustom (jika diperlukan)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("customer").password(passwordEncoder().encode("customer")).roles("CUSTOMER")
                .and()
                .withUser("merchant").password(passwordEncoder().encode("merchant")).roles("MERCHANT");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/signup").permitAll() // URL pendaftaran yang dapat diakses tanpa otentikasi
//                .anyRequest().authenticated() // Semua URL lainnya memerlukan otentikasi
//                .and()
//                .formLogin()
//                .loginPage("/login") // Halaman login kustom (jika diperlukan)
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
}
