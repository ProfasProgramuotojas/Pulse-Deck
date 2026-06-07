package com.emcekus.pulsedeck.repository;

import com.emcekus.pulsedeck.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}