package com.emcekus.pulsedeck.controller;

import com.emcekus.pulsedeck.dto.TicketDetailDto;
import com.emcekus.pulsedeck.dto.TicketSummaryDto;
import com.emcekus.pulsedeck.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<TicketSummaryDto> all() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketSummaryDto::from)
                .toList();
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDetailDto> one(@PathVariable Long ticketId) {
        return ticketRepository.findById(ticketId)
                .map(TicketDetailDto::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}