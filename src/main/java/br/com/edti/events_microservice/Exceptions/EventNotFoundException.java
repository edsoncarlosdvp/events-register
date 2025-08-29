package br.com.edti.events_microservice.Exceptions;

public class EventNotFoundException extends RuntimeException {

  public EventNotFoundException() {
    super("Evento não encontrado");
  }

  public EventNotFoundException(String message) {
    super(message);
  }
}