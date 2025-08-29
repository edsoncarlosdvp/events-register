package br.com.edti.events_microservice.Domain;

import br.com.edti.events_microservice.DTOs.EventRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "events")
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String registeredParticipants;
  private String maxParticipants;
  private String date;
  private String title;
  private String description;

  public Event(EventRequestDTO eventRequest) {
    this.registeredParticipants = String.valueOf(eventRequest.registeredParticipants());
    this.maxParticipants = String.valueOf(eventRequest.maxParticipants());
    this.date = eventRequest.date();
    this.title = eventRequest.title();
    this.description = eventRequest.description();
  }
}