package com.example.student.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "swagger.property")
public class SwaggerProperty {
	
	private String basePackage;
	
	private String appName;

}
