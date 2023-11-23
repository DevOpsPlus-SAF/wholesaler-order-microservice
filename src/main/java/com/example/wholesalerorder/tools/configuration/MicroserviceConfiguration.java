package com.example.wholesalerorder.tools.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("microserviceConfiguration")
public class MicroserviceConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return (new OpenAPI())
                .components(new Components())
                .info(new Info()
                        .title("Ksero Products Microservice")
                        .description("Mid-term Project"));
    }
}
