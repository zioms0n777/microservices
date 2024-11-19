package com.ziomson.department_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition
		(
				info = @Info(
						title = "Department Service REST APIs",
						description = "Department Service REST APIs Documentation",
						version = "6.9",
						contact = @Contact(
								name = "ziomson",
								email = "ziomson777@outlook.com",
								url = "https://www.ziomson.com"
						),
						license = @License(
								name = "Apache 2.0",
								url = "https://www.ziomson.com"
						)
				),
				externalDocs = @ExternalDocumentation(
						description = "Department-Service Doc",
						url = "https://www.ziomson.com"
				)
		)


@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
