package br.com.edti.events_microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edti.events_microservice.Domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
