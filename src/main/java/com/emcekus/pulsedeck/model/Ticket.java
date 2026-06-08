package com.emcekus.pulsedeck.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comment comment;

    private String title;
    private String category;
    private String priority;
    private String summary;

    public Long getTicketId() {
        return ticketId;
    }

    public Comment getComment() {
        return comment;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
}