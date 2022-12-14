package com.hacatac.microservices.controller;

import com.hacatac.microservices.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchange currencyExchange;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable("from")String from,
            @PathVariable("to")String to){

        currencyExchange.setId(1000L);
        currencyExchange.setFrom(from);
        currencyExchange.setTo(to);
        currencyExchange.setConversionMultiple(BigDecimal.valueOf(50));

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
