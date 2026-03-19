package com.example.marketconnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("api.places.base-url")
    private String placesApi;

    @Bean("placesApiWebClient")
    WebClient placesApiClient(){
        return WebClient.builder().baseUrl(placesApi).build();
    }
}
