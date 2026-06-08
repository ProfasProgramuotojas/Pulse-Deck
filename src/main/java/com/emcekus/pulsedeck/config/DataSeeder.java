package com.emcekus.pulsedeck.config;

import com.emcekus.pulsedeck.model.Comment;
import com.emcekus.pulsedeck.model.Ticket;
import com.emcekus.pulsedeck.repository.CommentRepository;
import com.emcekus.pulsedeck.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(CommentRepository comments, TicketRepository tickets) {
        return args -> {
            if (comments.count() > 0) return;

            Comment c1 = new Comment();
            c1.setProduct("Mobile App");
            c1.setComment("Love the new dark mode, looks great!");
            comments.save(c1);

            Comment c2 = new Comment();
            c2.setProduct("Web Dashboard");
            c2.setComment("Thanks for the fast support last week.");
            comments.save(c2);

            Comment c3 = new Comment();
            c3.setProduct("Billing");
            c3.setComment("I was charged twice for my subscription this month.");
            comments.save(c3);

            Ticket t1 = new Ticket();
            t1.setTitle("Duplicate subscription charge");
            t1.setCategory("billing");
            t1.setPriority("high");
            t1.setSummary("User reports being billed twice in one cycle.");
            t1.setComment(c3);
            tickets.save(t1);

            Comment c4 = new Comment();
            c4.setProduct("Mobile App");
            c4.setComment("App crashes every time I open the settings screen.");
            comments.save(c4);

            Ticket t2 = new Ticket();
            t2.setTitle("Crash on settings screen");
            t2.setCategory("bug");
            t2.setPriority("medium");
            t2.setSummary("App consistently crashes when opening settings.");
            t2.setComment(c4);
            tickets.save(t2);
        };

    }
}