package com.odev.biletleme;

import com.odev.biletleme.model.BuyTicketDto;
import com.odev.biletleme.services.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void testBuyTicket(){
        BuyTicketDto buyTicketDto=new BuyTicketDto();
        buyTicketDto.setPassengerName("şeyda");
        buyTicketDto.setPassgerSurname("özer");
        buyTicketDto.setRouteID((long) 1);
        ticketService.createTicket(buyTicketDto);
    }

    @Test
    public void testGetByTicketID(){
        ticketService.findTicketByTicketNumber("aaaaaaaaaaaa");
    }

    @Test
    public void testCancelTicket(){
        ticketService.cancelTicket("aaaaaaaaaaa");
    }
}
