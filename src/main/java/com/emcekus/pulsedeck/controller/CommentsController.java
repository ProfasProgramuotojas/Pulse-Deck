package com.emcekus.pulsedeck.controller;

import com.emcekus.pulsedeck.repository.CommentRepository;
import com.emcekus.pulsedeck.repository.TicketRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "${app.client.url}")
public class CommentsController {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;

    public CommentsController(CommentRepository commentRepository, TicketRepository ticketRepository) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public Map<String, Object> all() {
        return Map.of(
                "comments", commentRepository.findAll(),
                "tickets", ticketRepository.findAll()
        );
    }
}