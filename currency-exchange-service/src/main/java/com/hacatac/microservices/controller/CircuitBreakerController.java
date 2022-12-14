package com.hacatac.microservices.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger =
            LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "fallBackResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "fallBackResponse")
    //10s => 10000 calls to the sample api
    //@RateLimiter(name = "default")
    //@Bulkhead(name = "sample-api")
    public String sampleApi(){
        logger.info("SAMPLE API CALL RECEIVED");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }
//    public String sampleApi(){
//        logger.info("SAMPLE API CALL RECEIVED");
//        return "sample-api";
//    }

    private String fallBackResponse(Exception ex){
        logger.info("Fallback Response Called");
        return ex.getMessage();
    }

}
