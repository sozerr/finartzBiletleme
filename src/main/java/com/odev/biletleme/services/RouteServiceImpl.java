package com.odev.biletleme.services;

import com.odev.biletleme.entity.RouteEntity;
import com.odev.biletleme.repository.AirlinesRepo;
import com.odev.biletleme.repository.AirportsRepo;
import com.odev.biletleme.repository.RouteRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService, Serializable {

    @Autowired
    RouteRepo routeRepo;

    @Autowired
    AirlinesRepo airlinesRepo;

    @Autowired
    AirportsRepo airportsRepo;

    private static final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Override
    public RouteEntity createRoute(RouteEntity routeEntity) {
        RouteEntity saved = new RouteEntity();
        try {
            if (routeEntity.getRouteID() == 0 || routeEntity.getRouteID() == null) {
                if (airlinesRepo.findByName(routeEntity.getAirlines().toUpperCase()) != null && airportsRepo.findByName(routeEntity.getArrivalAirport().toUpperCase()) != null &&
                        airportsRepo.findByName(routeEntity.getDepartureAirport().toUpperCase()) != null) {
                    routeEntity.setDepartureAirport(routeEntity.getDepartureAirport().toUpperCase());
                    routeEntity.setArrivalAirport(routeEntity.getArrivalAirport().toUpperCase());
                    routeEntity.setAirlines(routeEntity.getAirlines().toUpperCase());
                    routeEntity.setLastSeatCount(routeEntity.getTotalSeats());
                    routeEntity.setLastPrice(Double.valueOf(routeEntity.getFirstPrice()));
                    saved = routeRepo.save(routeEntity);

                } else {
                    logger.info("Check field");
                    throw new Exception();
                }

            } else {
                logger.info("This route already exist! ");
                throw new Exception();
            }

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return saved;
    }

    @Override
    public List<RouteEntity> getAllRoute() {
        List<RouteEntity> routeEntities = new ArrayList<>();
        try {
            routeEntities = routeRepo.findAll();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return routeEntities;
    }

    @Override
    public RouteEntity findRouteById(Long id) {
        RouteEntity routeEntity = new RouteEntity();
        try {
            routeEntity = routeRepo.getOne(id);

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return routeEntity;
    }
}
