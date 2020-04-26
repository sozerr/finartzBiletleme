package com.odev.biletleme.services;

import com.odev.biletleme.entity.RouteEntity;

import java.util.List;

public interface RouteService {
    RouteEntity createRoute (RouteEntity routeEntity);
    List<RouteEntity> getAllRoute();
    RouteEntity findRouteById(Long id);
}
