package com.mypack.spring.boot.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class AsyncServiceImpl implements AsyncService {
    private static Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Async("myThreadPoolExecutor")
    public void asyncMethod() {
        log.info("asyncMethod: execution started.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("asyncMethod: execution completed.");
    }

    @Override
    @Async("myThreadPoolExecutor")
    public CompletableFuture<String> asyncWithCompletable() {
        log.info("asyncWithCompletable: execution started.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("asyncWithCompletable: execution completed.");
        return CompletableFuture.completedFuture("Successfully executed");
    }
}
