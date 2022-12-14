package com.hacatac.microservices.exception;

import com.hacatac.microservices.entity.CurrencyExchange;
import org.springframework.http.HttpStatus;

public class CurrencyExchangeExceptionHandler extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public CurrencyExchangeExceptionHandler(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public CurrencyExchangeExceptionHandler(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
