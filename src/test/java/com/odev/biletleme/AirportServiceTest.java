package com.odev.biletleme;

import com.odev.biletleme.entity.AirportsEntity;
import com.odev.biletleme.services.AirportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class AirportServiceTest {

    @Autowired
    AirportService airportService;

    @Test
    public void testCreateAirport() {
        AirportsEntity airportsEntity = new AirportsEntity();
        airportsEntity.setAirportID((long) 1);
        airportsEntity.setCity("AAA");
        airportsEntity.setCountry("ddd");
        airportsEntity.setName("sdd");
        airportService.createAirport(airportsEntity);
    }

    @Test
    public void testGetAllAirports() {
        airportService.findAllAirports();
    }
}
