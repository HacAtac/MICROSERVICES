package com.hacatac.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeDto {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;


}