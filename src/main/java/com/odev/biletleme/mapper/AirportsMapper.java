package com.odev.biletleme.mapper;

import com.odev.biletleme.model.AirportDto;
import com.odev.biletleme.entity.AirportsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportsMapper {
    AirportsEntity dtoToEntity(AirportDto dto);

    AirportDto entityToDto(AirportsEntity entity);
}
