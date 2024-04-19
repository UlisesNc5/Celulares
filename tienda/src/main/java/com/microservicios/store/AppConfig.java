package com.microservicios.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean("ClientRest")
    RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }

}
