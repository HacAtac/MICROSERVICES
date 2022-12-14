package com.hacatac.microservices.service;

import com.hacatac.microservices.model.CurrencyExchangeDto;

public interface CurrencyService {

    CurrencyExchangeDto getCurrencyExchange(String from, String to);



}
