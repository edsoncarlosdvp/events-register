package br.com.edti.events_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EventsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsMicroserviceApplication.class, args);
	}

}
