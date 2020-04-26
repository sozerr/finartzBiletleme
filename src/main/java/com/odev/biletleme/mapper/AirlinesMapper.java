package com.odev.biletleme.mapper;

import com.odev.biletleme.entity.AirlinesEntity;
import com.odev.biletleme.model.AirlinesDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AirlinesMapper {

    AirlinesEntity dtoToEntity(AirlinesDto dto);
    AirlinesDto entityToDto(AirlinesEntity entity);
}
