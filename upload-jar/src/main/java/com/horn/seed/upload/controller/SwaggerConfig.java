package com.horn.seed.upload.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {
	@Override

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
	
	  /**
	   * Swagger bean
	   * @return Swagger bean
	   */
	  @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.horn.seed.upload.controller"))
	      .paths(PathSelectors.regex("/upload-jar.*|/legacy.*"))
	      .build()
	      .apiInfo(apiInfo());
	  }

	 

	  private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo("XYZ",
	      "XYZZ", "1.0",
	      "urn:tos", ApiInfo.DEFAULT_CONTACT, "com.abhi", "", new ArrayList<>());
	    return apiInfo;
	  }
/*		private ApiInfo apiInfo() {
			ApiInfo apiInfo = new ApiInfo("SaurzCode API", "API for Saurzcode", "Saurzcode API terms of service",
					"mail2saurzcode@gmail.com", "Saurzcode API Licence Type", "Saurzcode API License URL");
			return apiInfo;
		}*/
}