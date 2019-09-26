package com.MatrizDeConhecimento.swagger.configuration;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 
public class SwaggerConfiguration {

	@Bean
	public Docket api(){
		
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.MatrizDeConhecimento"))
		.build()
		.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder()
					.title("Matriz de Conhecimento")
					.description("Faz o cadastro, consulta, alteração e exclusão de competencias de um colaborador")
					.version("1.2.0")
					.build();
	}
}
