package com.odev.biletleme.services;

import com.odev.biletleme.entity.AirportsEntity;

import java.util.List;

public interface AirportService {
    AirportsEntity createAirport(AirportsEntity airportsEntity);

    List<AirportsEntity> findAllAirports();
}
