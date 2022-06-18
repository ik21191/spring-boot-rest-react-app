package com.mypack;

import com.mypack.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1")

public class MyController {
    private static Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public ResponseEntity<String> getHomePage() {
        log.info("getHomePage() called.");
        return ResponseEntity.ok().body("Application is up.");
    }

    @GetMapping("/employees")
    public ResponseEntity<String> getAllEmployees() {
        return ResponseEntity.ok().body(myService.getDetails());
    }
}
