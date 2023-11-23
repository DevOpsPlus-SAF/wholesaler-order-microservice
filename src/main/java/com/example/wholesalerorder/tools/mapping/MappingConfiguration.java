package com.example.wholesalerorder.tools.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }
}
