package com.horn.seed.upload.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;

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
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error")))
	      .build()
	      .apiInfo(apiInfo());
	  }

	 

	  private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo("Upload API",
	      "Api for uploading post images", "1.0",
	      "urn:tos", ApiInfo.DEFAULT_CONTACT, "com.horn.seed.upload", "", new ArrayList<>());
	    return apiInfo;
	  }
	  
	/*  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	      converters.add(byteArrayHttpMessageConverter());
	  }
	   
	  @Bean
	  public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
	      ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
	      arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
	      return arrayHttpMessageConverter;
	  }
	   
	  private List<MediaType> getSupportedMediaTypes() {
	      List<MediaType> list = new ArrayList<MediaType>();
	      list.add(MediaType.IMAGE_JPEG);
	      list.add(MediaType.IMAGE_PNG);
	      list.add(MediaType.APPLICATION_OCTET_STREAM);
	      return list;
	  }*/

}