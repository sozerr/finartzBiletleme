package com.odev.biletleme.mapper;

import com.odev.biletleme.entity.RouteEntity;
import com.odev.biletleme.model.RouteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface RouteMapper {
    RouteEntity dtoToEntity(RouteDTO dto);

    RouteDTO entityToDto(RouteEntity entity);
}
