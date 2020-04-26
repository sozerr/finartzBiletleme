package com.odev.biletleme;

import com.odev.biletleme.entity.AirlinesEntity;
import com.odev.biletleme.services.AirlinesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class AirlinesServiceTest {
    @Autowired
    AirlinesService airlinesService;

    @Test
    public void testCreateAirlines() {
        AirlinesEntity airlinesEntity = new AirlinesEntity();
        airlinesEntity.setAirlinesID((long) 1);
        airlinesEntity.setName("thy");
        airlinesService.createAirlines(airlinesEntity);
    }

    @Test
    public void testGetAllAirlines() {
        airlinesService.findAirlines();
    }
}
