package com.mypack.spring.boot.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    public void asyncMethod();
    public CompletableFuture<String> asyncWithCompletable();
}
