package com.odev.biletleme.services;

import com.odev.biletleme.entity.RouteEntity;
import com.odev.biletleme.entity.TicketEntity;
import com.odev.biletleme.model.BuyTicketDto;
import com.odev.biletleme.repository.RouteRepo;
import com.odev.biletleme.repository.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    RouteRepo routeRepo;

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Override
    public TicketEntity createTicket(BuyTicketDto buyTicketDto) {
        TicketEntity ticketEntity = new TicketEntity();
        try {
            RouteEntity routeEntity = routeRepo.findByRouteID(buyTicketDto.getRouteID());
            if (routeEntity != null) {
                if (routeEntity.getLastSeatCount() > 0) {
                    ticketEntity.setTicketNumber(UUID.randomUUID().toString());
                    ticketEntity.setFlightDate(routeEntity.getFlightDate());
                    ticketEntity.setDepartureAirport(routeEntity.getDepartureAirport());
                    ticketEntity.setArrivalAirport(routeEntity.getArrivalAirport());
                    ticketEntity.setPassengerFullName(buyTicketDto.getPassengerName().toUpperCase() + " " + buyTicketDto.getPassgerSurname().toUpperCase());
                    ticketEntity.setPrice(routeEntity.getLastPrice().toString() + " TL");
                    ticketEntity.setSeat(routeEntity.getLastSeatCount().toString());
                    ticketEntity.setRouteID(buyTicketDto.getRouteID());
                    sales(routeEntity.getRouteID());

                    ticketRepo.save(ticketEntity);
                } else {
                    logger.error("Bu rotada yer kalmamıştır.");
                    throw new IllegalArgumentException();
                }
            } else {
                logger.error("Bu rota yok.");
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            logger.error(e.toString());

        }
        return ticketEntity;
    }

    @Override
    public TicketEntity findTicketByTicketNumber(String ticketNumber) {
        TicketEntity ticketEntity = new TicketEntity();
        try {
            ticketEntity = ticketRepo.findByTicketNumber(ticketNumber);

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return ticketEntity;
    }

    @Override
    public Boolean cancelTicket(String ticketNumber) {
        TicketEntity ticketEntity = new TicketEntity();
        try {
            ticketEntity = ticketRepo.findByTicketNumber(ticketNumber);
            if (ticketEntity != null) {
                RouteEntity routeEntity = routeRepo.getOne(ticketEntity.getRouteID());
                routeEntity.setLastSeatCount(routeEntity.getLastSeatCount() + 1);
                routeRepo.save(routeEntity);
                ticketRepo.delete(ticketEntity);
                return true;
            }else{
                logger.error("Bu TicketNumber'a ait bir bilet bulunamadı.");
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return false;
        }
    }

    private RouteEntity sales(Long routeId) {
        RouteEntity routeEntity = routeRepo.getOne(routeId);

        routeEntity.setLastSeatCount(routeEntity.getLastSeatCount() - 1);

        if (routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .1)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice());
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .1) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .2)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.1);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .2) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .3)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.2);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .3) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .4)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.3);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .4) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .5)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.4);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .5) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .6)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.5);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .6) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .7)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.6);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .7) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .8)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.7);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .8) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .9)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.8);
        } else if (routeEntity.getLastSeatCount() <= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * .9) && routeEntity.getLastSeatCount() >= routeEntity.getTotalSeats() - (routeEntity.getTotalSeats() * 1)) {
            routeEntity.setLastPrice(routeEntity.getFirstPrice() * 1.9);
        }
        routeEntity = routeRepo.save(routeEntity);
        return routeEntity;
    }

}
