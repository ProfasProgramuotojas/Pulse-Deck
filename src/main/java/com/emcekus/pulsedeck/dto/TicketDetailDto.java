package com.emcekus.pulsedeck.dto;

import com.emcekus.pulsedeck.model.Comment;
import com.emcekus.pulsedeck.model.Ticket;

public class TicketDetailDto {
    public Long ticketId;
    public String title;
    public String category;
    public String priority;
    public String summary;
    public Long commentId;
    public String product;
    public String comment;

    public static TicketDetailDto from(Ticket ticket) {
        TicketDetailDto dto = new TicketDetailDto();
        dto.ticketId = ticket.getTicketId();
        dto.title = ticket.getTitle();
        dto.category = ticket.getCategory();
        dto.priority = ticket.getPriority();
        dto.summary = ticket.getSummary();

        Comment c = ticket.getComment();
        if (c != null) {
            dto.commentId = c.getCommentId();
            dto.product = c.getProduct();
            dto.comment = c.getComment();
        }
        return dto;
    }
}