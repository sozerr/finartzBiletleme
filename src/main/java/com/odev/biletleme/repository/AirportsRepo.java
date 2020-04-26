package com.odev.biletleme.repository;

import com.odev.biletleme.entity.AirportsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportsRepo extends JpaRepository<AirportsEntity, Long>, JpaSpecificationExecutor<AirportsEntity> {
    AirportsEntity findAirportsEntitiesByName(String name);
    AirportsEntity deleteByName(String name);
    AirportsEntity findByName(String name);
}
