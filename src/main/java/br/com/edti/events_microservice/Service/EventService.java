package br.com.edti.events_microservice.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edti.events_microservice.DTOs.EmailRequestDTO;
import br.com.edti.events_microservice.DTOs.EventRequestDTO;
import br.com.edti.events_microservice.Domain.Event;
import br.com.edti.events_microservice.Domain.Subscription;
import br.com.edti.events_microservice.Exceptions.EventFullException;
import br.com.edti.events_microservice.Exceptions.EventNotFoundException;
import br.com.edti.events_microservice.Repository.EventRepository;
import br.com.edti.events_microservice.Repository.SubscriptionRepository;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @Autowired
  private EmailService emailServiceClient;

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  public List<Event> getUpcomingEvents() {
    return eventRepository.findUpcomingEvents(LocalDateTime.now());
  }

  public Event createEvent(EventRequestDTO eventRequest) {
    Event newEvent = new Event(eventRequest);
    return eventRepository.save(newEvent);
  }

  private Boolean isEventFull(Event event){
    int registeredParticipants = Integer.parseInt(event.getRegisteredParticipants());
    int maxParticipants = Integer.parseInt(event.getMaxParticipants());
    return registeredParticipants >= maxParticipants;
  }

  public void registerParticipant(String eventId, String participantEmail) {
    Event event = eventRepository.findById(eventId).orElseThrow((EventNotFoundException::new));

    if(isEventFull(event)) {
      throw new EventFullException();
    }

    Subscription subscription = new Subscription(event, participantEmail);
    subscriptionRepository.save(subscription);

    event.setRegisteredParticipants(event.getRegisteredParticipants() + 1);

    EmailRequestDTO emailRequest = new EmailRequestDTO(participantEmail, "Confirmação de Inscrição", "Você foi inscrito no evento com sucesso!");

    emailServiceClient.sendEmail(emailRequest);
  }
}
