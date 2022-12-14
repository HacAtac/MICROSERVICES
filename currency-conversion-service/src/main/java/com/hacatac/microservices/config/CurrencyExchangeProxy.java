package com.hacatac.microservices.config;
import com.hacatac.microservices.model.CurrencyConversionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange") //by removing url, it will auto do load balancing
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionDto retrieveExchangeValue
            (@PathVariable String from,
             @PathVariable String to);
}
