package com.MatrizDeConhecimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MatrizdeConhecimentosApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MatrizdeConhecimentosApplication.class, args);
		
	}

}
