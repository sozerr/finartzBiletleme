package com.odev.biletleme.services;

import com.odev.biletleme.entity.AirlinesEntity;

import java.util.List;

public interface AirlinesService {

    AirlinesEntity createAirlines(AirlinesEntity airlinesEntity);

    List<AirlinesEntity> findAirlines();
}
