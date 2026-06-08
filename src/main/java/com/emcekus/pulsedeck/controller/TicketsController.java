package com.emcekus.pulsedeck.controller;

import com.emcekus.pulsedeck.model.Ticket;
import com.emcekus.pulsedeck.repository.TicketRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "${app.client.url}")
public class TicketsController {

    private final TicketRepository ticketRepository;

    public TicketsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<Ticket> all() {
        return ticketRepository.findAll();
    }
}