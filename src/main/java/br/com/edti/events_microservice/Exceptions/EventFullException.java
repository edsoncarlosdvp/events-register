package br.com.edti.events_microservice.Exceptions;

public class EventFullException extends RuntimeException {
  
  public EventFullException() {
    super("Evento está cheio!");
  }

  public EventFullException(String message) {
    super(message);
  }
}
