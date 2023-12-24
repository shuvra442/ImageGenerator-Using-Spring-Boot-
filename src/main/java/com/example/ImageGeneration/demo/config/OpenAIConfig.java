package com.example.ImageGeneration.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

    private static final String openApiKey = "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";

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}

