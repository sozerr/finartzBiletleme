package com.odev.biletleme;

import com.odev.biletleme.entity.RouteEntity;
import com.odev.biletleme.services.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class RouteServiceTest {

    @Autowired
    RouteService routeService;

    @Test
    public void testCreateRoute() {

        Date date=new Date();
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setLastSeatCount(100);
        routeEntity.setLastPrice((double) 100);
        routeEntity.setAirlines("aaa");
        routeEntity.setArrivalAirport("bb");
        routeEntity.setDepartureAirport("eee");
        routeEntity.setFirstPrice(100);
        routeEntity.setFlightDate(date);
        routeEntity.setRouteID((long)1);
        routeService.createRoute(routeEntity);
    }

    @Test
    public void testGetAllRoute(){
        routeService.getAllRoute();
    }
}
