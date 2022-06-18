package com.mypack.spring.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.mypack.spring.config"})
public class SpringBootMainClass {

	public static void main(String[] ar) {
		SpringApplication.run(SpringBootMainClass.class, ar);
	}

}
