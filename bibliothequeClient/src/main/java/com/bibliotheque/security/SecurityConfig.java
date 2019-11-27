package com.bibliotheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackageClasses = CustomAuthentication.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

    @Autowired
    private CustomAuthentication customAuthentication;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder bcpe = getBCPE();
        auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("1234")).roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
        //  auth.authenticationProvider(customAuthentication);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("static", "/img/**", "/", "/livres", "/livre", "/loginApp", "/search", "/detail-membre", "/prolongation")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }


    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


}


