package com.vaxsys.config;

import com.vaxsys.service.UserAuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.vaxsys.constant.Role.ADMIN;
import static com.vaxsys.constant.Role.NURSE;
import static com.vaxsys.constant.Role.PATIENT;
import static com.vaxsys.constant.Role.VENDOR;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserAuthenticationService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/admin/**").hasAuthority(ADMIN.toString())
                .antMatchers("/patient/**").hasAuthority(PATIENT.toString())
                .antMatchers("/nurse/**").hasAuthority(NURSE.toString())
                .antMatchers("/vendor/**").hasAuthority(VENDOR.toString())
                .and().csrf().disable().cors();
    }
}
