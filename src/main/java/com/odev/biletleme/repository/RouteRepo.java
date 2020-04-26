package com.odev.biletleme.repository;

import com.odev.biletleme.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<RouteEntity, Long>, JpaSpecificationExecutor<RouteEntity> {
    RouteEntity findByRouteID(Long id);
}
