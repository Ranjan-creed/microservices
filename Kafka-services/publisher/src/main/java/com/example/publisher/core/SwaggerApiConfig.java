package com.example.publisher.core;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConfigurationProperties("app.api")
@ConditionalOnProperty(name = "api.swagger.enable", havingValue = "true", matchIfMissing = false)
@AllArgsConstructor
public class SwaggerApiConfig {

	private final SwaggerProperty swaggerProperty;

	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage())).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());

		return docket;

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(swaggerProperty.getAppName()).build();
	}

}
