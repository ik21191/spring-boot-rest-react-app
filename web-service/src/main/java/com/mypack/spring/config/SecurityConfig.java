package com.mypack.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*  
	@Bean
	  @Override public UserDetailsService userDetailsService() {
	  
		//User Role
        UserDetails theUser = User.withUsername("sergey")
                        .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                        .password("12345678").roles("USER").build();
        
        //Manager Role 
        UserDetails theManager = User.withUsername("john")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("87654321").roles("MANAGER").build();
        
  
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
              
        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager);
	        
	    return userDetailsManager; 
	  }
	  
	  */
	 
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/*").hasRole("USER")
                .antMatchers("/*actuator*").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
	/**We have defined user and password in application.properties file, so below method is not required.*/
	
	/*
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("imran")
                .password("{noop}12345678")
                .roles("USER")
                .and()
                .withUser("John")
                .password("{noop}12345678")
                .roles("MANAGER");
    }
    */
	
}
