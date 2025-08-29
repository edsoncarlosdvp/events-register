package br.com.edti.events_microservice.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.edti.events_microservice.Domain.Event;
import jakarta.annotation.Nonnull;

public interface EventRepository extends JpaRepository<Event, String> {

  @Query(value = "SELECT * FROM events e WHERE PARSE(e.date AS TIMESTAMP) >: currentDate", nativeQuery = true)
  List<Event> findUpcomingEvents(@Param("currentDate") LocalDateTime currentDate);

  @SuppressWarnings("null")
  @Nonnull
  @Override
  Optional<Event> findById(@Nonnull String id);
}
