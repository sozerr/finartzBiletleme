package com.odev.biletleme.services;

import com.odev.biletleme.entity.TicketEntity;
import com.odev.biletleme.model.BuyTicketDto;

public interface TicketService {

    TicketEntity createTicket(BuyTicketDto buyTicketDto);

    TicketEntity findTicketByTicketNumber(String ticketNumber);

    Boolean cancelTicket(String ticketNumber);
}
