package com.javanauta.agendadortarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class AgendadorTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorTarefaApplication.class, args);
	}

}
