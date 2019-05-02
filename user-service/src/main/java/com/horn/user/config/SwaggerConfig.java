package com.horn.user.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Abhishek
 *
 * Configuration for Swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {	
	  /**
	   * Swagger bean
	   * @return Swagger bean
	   */
	  @Bean
	  public Docket api() { 
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.horn.user.controller"))
	      .paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error")))
	      .build()
	      .apiInfo(apiInfo());
	  }

	 

	  private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo("Upload API",
	      "Api for user service", "1.0",
	      "urn:tos", ApiInfo.DEFAULT_CONTACT, "com.horn.seed.user", "", new ArrayList<>());
	    return apiInfo;
	  }
}