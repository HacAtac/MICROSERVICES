package com.hacatac.microservices.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("limits-service")
@Component
public class Configuration {
    private int minimum;
    private int maximum;


}
