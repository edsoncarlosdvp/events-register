package br.com.edti.events_microservice.DTOs;

public record EmailRequestDTO(String to, String subject, String body) {

}
