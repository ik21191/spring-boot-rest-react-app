package com.mypack.spring.rest.controller;

import com.mypack.spring.boot.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class AsyncController {
    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    private final AsyncService asyncService;
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/call1")
    public ResponseEntity<String> call1() {
        log.info("call1() method is started");
        asyncService.asyncMethod();
        log.info("call1() method is ended");
        return ResponseEntity.ok().body("async service started");
    }

    @GetMapping("/call2")
    public ResponseEntity<String> call2() throws Exception {
        log.info("call2() method is started");
        CompletableFuture<String> completableFuture = asyncService.asyncWithCompletable();
        log.info("call2() waiting for the result");
        String result = completableFuture.get();
        log.info("call2() got the result");
        log.info("call2() method is ended");
        return ResponseEntity.ok().body(result);
    }
}
