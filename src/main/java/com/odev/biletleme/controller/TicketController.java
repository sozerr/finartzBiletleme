package com.odev.biletleme.controller;

import com.odev.biletleme.common.CommonResponse;
import com.odev.biletleme.entity.TicketEntity;
import com.odev.biletleme.mapper.TicketMapper;
import com.odev.biletleme.model.BuyTicketDto;
import com.odev.biletleme.services.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    CommonResponse<TicketEntity> commonResponse = new CommonResponse<>();

    @RequestMapping(value = "/get-by-ticker-number/{ticketNumber}", method = RequestMethod.GET)
    public CommonResponse<TicketEntity> getTicket(@PathVariable(value = "ticketNumber") String ticketNumber) {
        try {
            TicketEntity ticketEntity = ticketService.findTicketByTicketNumber(ticketNumber);
            commonResponse.setResult(ticketEntity);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResponse<TicketEntity> buyTicket(@RequestBody BuyTicketDto buyTicketDto) {
        TicketEntity ticketEntity = new TicketEntity();
        try {
            ticketEntity = ticketService.createTicket(buyTicketDto);
            if (ticketEntity.getRouteID() != null) {
                commonResponse.setResult(ticketMapper.entityToDto(ticketEntity));
                commonResponse.setSuccess(true);
            } else {
                commonResponse.setResultInfo("Bilet oluşturulamadı!");
                throw new Exception();
            }
        } catch (
                Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

    @RequestMapping(value = "/cancel/{ticketNumber}", method = RequestMethod.GET)
    public CommonResponse<TicketEntity> cancelTicket(@PathVariable(value = "ticketNumber") String ticketNumber) {
        try {
            if (ticketService.cancelTicket(ticketNumber)) {
                commonResponse.setResultInfo("Biletiniz iptal edilmiştir.");
            } else {
                commonResponse.setResultInfo("HATA! Işlem Başarsız.");
            }
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

}
