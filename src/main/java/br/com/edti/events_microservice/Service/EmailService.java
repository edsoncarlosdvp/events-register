package br.com.edti.events_microservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.edti.events_microservice.DTOs.EmailRequestDTO;

@FeignClient(name = "email-service", url = "http://localhost:8081")
public interface  EmailService {

  @PostMapping("/send")
  void sendEmail(@RequestBody EmailRequestDTO emailRequest);
}
