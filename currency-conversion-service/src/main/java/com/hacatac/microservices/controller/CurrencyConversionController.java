package com.hacatac.microservices.controller;

import com.hacatac.microservices.model.CurrencyConversionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
   private  CurrencyConversionDto currencyConversionDto;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDto calculateCurrencyConversion(@PathVariable String from,
                                                             @PathVariable String to,
                                                             @PathVariable BigDecimal quantity
    ) {

        HashMap<String, String> uriVariables= new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionDto> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionDto.class, uriVariables);

        CurrencyConversionDto currencyConversion = responseEntity.getBody();


            return new CurrencyConversionDto(
                    currencyConversion.getId(),
                    from,
                    to,
                    quantity,
                    currencyConversion.getConversionMultiple(),
                    quantity.multiply(currencyConversion.getConversionMultiple()),
                    currencyConversion.getEnvironment()
            );
    }


}
