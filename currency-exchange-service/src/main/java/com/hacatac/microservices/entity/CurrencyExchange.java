package com.hacatac.microservices.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange {
    @Id
    private Long id;
    @Column(
            name = "currency_from"
    )
    private String from;
    @Column(
            name = "currency_to"
    )
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}