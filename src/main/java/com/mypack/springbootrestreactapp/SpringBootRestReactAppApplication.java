package com.mypack.springbootrestreactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootRestReactAppApplication extends SpringBootServletInitializer {

	public static void main(String[] ar) {
		SpringApplication.run(SpringBootRestReactAppApplication.class, ar);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(SpringBootRestReactAppApplication.class);
	}

}
