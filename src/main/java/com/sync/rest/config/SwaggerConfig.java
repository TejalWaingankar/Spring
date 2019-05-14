package com.sync.rest.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Set<String> Default_Produces_Consumes = new HashSet<String>(Arrays.asList("application/json"));

	@Value("${server.port}")
	private String appPort;
	
	@Value("${server.servlet.context-path}")
	private String appRoot;
	
	@Bean
	public Docket demoApi() {
		String docsURL = "http://localhost:"+appPort+appRoot+"/v2/api-docs";

		Contact default_contact = new Contact("Tejal Waingankar", docsURL,"tejal.waingankar@gmail.com");

		ApiInfo apiInfo = new ApiInfo("Swagger for SpringBootRest", "Swagger Docs", "1.0", "Terms and Conditions", default_contact,
				"Free Licence", "http://swagger.licence.com");

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
				.produces(Default_Produces_Consumes)
				.consumes(Default_Produces_Consumes)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("(/actuator.*|/error.*)"))).build();
	}
}
