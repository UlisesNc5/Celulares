package com.microservicios.celulares.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket apiDocket(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.microservicios.celulares.controladores"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo  (){
		return new ApiInfo(
			"celulares", 
			"servicio para venta de celulares",
			"1.0.0",
			"TOS",
			new Contact("Ulises", "https://www.google.com", "test@test.test"),
			"GPL 3.0",
			"GPL License URL",
				Collections.emptyList());
	}
	
}
