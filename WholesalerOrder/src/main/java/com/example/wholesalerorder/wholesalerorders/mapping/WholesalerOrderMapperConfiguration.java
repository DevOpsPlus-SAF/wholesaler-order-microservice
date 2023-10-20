package com.example.wholesalerorder.wholesalerorders.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("wholesalerOrderMapperConfiguration")
public class WholesalerOrderMapperConfiguration {
    @Bean
    public WholesalerOrderMapper wholesalerOrderMapper() {
        return new WholesalerOrderMapper();
    }
}
