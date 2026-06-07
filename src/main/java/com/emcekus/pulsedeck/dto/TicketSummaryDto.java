package com.emcekus.pulsedeck.dto;

import com.emcekus.pulsedeck.model.Ticket;

public class TicketSummaryDto {
    public Long ticketId;
    public String title;
    public String category;
    public String priority;

    public static TicketSummaryDto from(Ticket ticket) {
        TicketSummaryDto dto = new TicketSummaryDto();
        dto.ticketId = ticket.getTicketId();
        dto.title = ticket.getTitle();
        dto.category = ticket.getCategory();
        dto.priority = ticket.getPriority();
        return dto;
    }
}