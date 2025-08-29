package br.com.edti.events_microservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edti.events_microservice.DTOs.EventRequestDTO;
import br.com.edti.events_microservice.Domain.Event;
import br.com.edti.events_microservice.Domain.Subscription;
import br.com.edti.events_microservice.Service.EventService;



@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping
  public List<Event> getAllEvents() {
      return eventService.getAllEvents();
  }
  
  @GetMapping("/upcoming")
  public List<Event> getUpcomingEvents(@RequestParam String param) {
      return eventService.getUpcomingEvents();
  }
  
  @PostMapping
  public Event creatEvent(@RequestBody EventRequestDTO event) {
      return eventService.createEvent(event);
  }
  
  @PostMapping("/{eventId}/register")
  public void registerParticipant(@PathVariable String eventId, @RequestBody Subscription subscriptionRequest) {
    eventService.registerParticipant(eventId, subscriptionRequest.getParticipantEmail());
  }
}
