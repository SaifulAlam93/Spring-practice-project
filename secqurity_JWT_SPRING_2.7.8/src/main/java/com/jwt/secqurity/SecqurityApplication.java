package com.jwt.secqurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Annual Day Participants"))

public class SecqurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecqurityApplication.class, args);
	}

}
