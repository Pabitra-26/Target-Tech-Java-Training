package com.target.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class EmployeeServiceApplication {


	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.paths(path->path.startsWith("/api/"))
				.apis(RequestHandlerSelectors.basePackage("com.target.training"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
