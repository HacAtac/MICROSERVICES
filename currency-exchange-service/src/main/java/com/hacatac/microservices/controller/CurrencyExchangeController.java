package com.hacatac.microservices.controller;

import com.hacatac.microservices.model.CurrencyExchangeDto;
import com.hacatac.microservices.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchangeDto> getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchangeDto currencyExchangeDto = currencyService.getCurrencyExchange(from, to);
        return ResponseEntity.ok(currencyExchangeDto);
    }

}
