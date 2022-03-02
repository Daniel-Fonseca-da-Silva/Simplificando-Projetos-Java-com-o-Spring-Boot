package com.dio.projetofeign2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Projetofeign2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projetofeign2Application.class, args);
	}

}
