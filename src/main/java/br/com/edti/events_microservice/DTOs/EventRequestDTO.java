package br.com.edti.events_microservice.DTOs;

public record EventRequestDTO(int maxParticipants, int registeredParticipants, String date, String title, String description) {

}
