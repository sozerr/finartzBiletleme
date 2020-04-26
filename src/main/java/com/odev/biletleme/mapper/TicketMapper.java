package com.odev.biletleme.mapper;

import com.odev.biletleme.entity.TicketEntity;
import com.odev.biletleme.model.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TicketMapper {
    TicketEntity dtoToEntity(TicketDto ticketDto);

    TicketDto entityToDto(TicketEntity ticketEntity);
}
