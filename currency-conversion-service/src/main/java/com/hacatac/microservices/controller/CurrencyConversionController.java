package com.hacatac.microservices.controller;

import com.hacatac.microservices.model.CurrencyConversionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @Autowired
   private  CurrencyConversionDto currencyConversionDto;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDto calculateCurrencyConversion(@PathVariable String from,
                                                             @PathVariable String to,
                                                             @PathVariable BigDecimal quantity
    ) {
            return new CurrencyConversionDto(
                    10001L,
                    "USD",
                    "INR",
                    BigDecimal.valueOf(100),
                    BigDecimal.valueOf(65),
                    BigDecimal.valueOf(6500),
                    ""
            );
    }


}
