package com.hexaphor.config;

import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.ArrayList;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket swaggerDocuments() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(basePackage("com.hexaphor.controller"))
				.paths(regex("/rest.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	@SuppressWarnings("rawtypes")
	private ApiInfo apiInfo() {
		return new ApiInfo("WEL COME TO HEXAPHORE DOCTOR SERVICE ",
				            "DOCTOR PRODUCT SERVICE",
				            "V2",
				            "http://hexaphor.com/",
				            new springfox.documentation.service.Contact("Pravat Kumar Behera", "http://hexaphor.com/", "saipravatkumar1996@gmail.com"),
				            "HEXAPHOR", 
				            "http://hexaphor.com/", 
				            new ArrayList<VendorExtension>());
	}


}
