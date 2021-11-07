package com.mypack.spring.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
	"com.mypack.spring.boot.main", 
	"com.mypack.spring.config", 
	"com.mypack.entities", 
	"com.mypack.spring.rest.controller", 
	"com.mypack.spring.exception"})

@EnableJpaRepositories("com.mypack.spring.repository")
@EntityScan("com.mypack.entities")

@SpringBootApplication
public class SpringBootMainClass {

	public static void main(String[] ar) {
		SpringApplication.run(SpringBootMainClass.class, ar);
	}

}
