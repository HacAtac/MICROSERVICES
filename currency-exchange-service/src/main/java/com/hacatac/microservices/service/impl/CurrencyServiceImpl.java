package com.hacatac.microservices.service.impl;

import com.hacatac.microservices.entity.CurrencyExchange;
import com.hacatac.microservices.model.CurrencyExchangeDto;
import com.hacatac.microservices.repository.CurrencyExchangeRepository;
import com.hacatac.microservices.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyExchangeRepository repository;

    @Override
    public CurrencyExchangeDto getCurrencyExchange(String from, String to) {
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        CurrencyExchangeDto currencyExchangeDto = new CurrencyExchangeDto();
        currencyExchangeDto.setId(currencyExchange.getId());
        currencyExchangeDto.setFrom(currencyExchange.getFrom());
        currencyExchangeDto.setTo(currencyExchange.getTo());
        currencyExchangeDto.setConversionMultiple(currencyExchange.getConversionMultiple());
        currencyExchangeDto.setEnvironment(currencyExchange.getEnvironment());
        return currencyExchangeDto;
    }
}
