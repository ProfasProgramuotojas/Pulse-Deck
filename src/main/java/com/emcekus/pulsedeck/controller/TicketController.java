package com.emcekus.pulsedeck.controller;

import com.emcekus.pulsedeck.model.Ticket;
import com.emcekus.pulsedeck.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "${app.client.url}")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> one(@PathVariable Long ticketId) {
        return ticketRepository.findById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}