package com.marcos.escola_microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DisciplinaMicroservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisciplinaMicroservicoApplication.class, args);
	}

}
