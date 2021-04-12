package com.mypack.springbootrestreactapp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.spring.rest.error.ResourceNotFoundException;

import java.util.Date;
 
@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() throws Exception {
    	System.out.println("hello() of HelloController is called");
    	int a = 1;
    	if(a == 1) {
    		//throw new ResourceNotFoundException();
    	}
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}