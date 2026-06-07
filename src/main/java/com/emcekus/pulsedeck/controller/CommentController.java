package com.emcekus.pulsedeck.controller;

import com.emcekus.pulsedeck.model.Comment;
import com.emcekus.pulsedeck.model.CommentAnalysis;
import com.emcekus.pulsedeck.model.Ticket;
import com.emcekus.pulsedeck.repository.CommentRepository;
import com.emcekus.pulsedeck.repository.TicketRepository;
import com.emcekus.pulsedeck.service.HuggingFaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;
    private final HuggingFaceService huggingFaceService;

    public CommentController(CommentRepository commentRepository,
                             TicketRepository ticketRepository,
                             HuggingFaceService huggingFaceService) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
        this.huggingFaceService = huggingFaceService;
    }

    @PostMapping
    public CommentAnalysis create(@RequestBody Comment comment) {
        Comment saved = commentRepository.save(comment);

        CommentAnalysis analysis = huggingFaceService.analyze(comment.getComment(), comment.getProduct());
        if (analysis.needsTicket) {
            Ticket ticket = new Ticket();
            ticket.setComment(saved);
            ticket.setTitle(analysis.title);
            ticket.setCategory(analysis.category);
            ticket.setPriority(analysis.priority);
            ticket.setDescription(analysis.summary);
            ticketRepository.save(ticket);
        }
        return analysis;
    }

    @GetMapping
    public List<Comment> all() {
        return commentRepository.findAll();
    }
}