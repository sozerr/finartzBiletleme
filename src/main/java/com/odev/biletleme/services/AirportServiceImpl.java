package com.odev.biletleme.services;

import com.odev.biletleme.entity.AirportsEntity;
import com.odev.biletleme.repository.AirportsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportsRepo airportsRepo;

    private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    @Override
    public AirportsEntity createAirport(AirportsEntity airportsEntity) {
        AirportsEntity savedEntity = new AirportsEntity();
        try {
            airportsEntity.setName(airportsEntity.getName().toUpperCase());
            savedEntity = airportsRepo.save(airportsEntity);
        } catch (Exception e) {
        }
        return savedEntity;
    }

    @Override
    public List<AirportsEntity> findAllAirports() {
        List<AirportsEntity> airportsEntities = new ArrayList<>();
        try {
            airportsEntities = airportsRepo.findAll();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return airportsEntities;
    }
}
