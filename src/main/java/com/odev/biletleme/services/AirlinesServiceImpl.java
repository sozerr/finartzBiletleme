package com.odev.biletleme.services;

import com.odev.biletleme.entity.AirlinesEntity;
import com.odev.biletleme.repository.AirlinesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlinesServiceImpl implements AirlinesService {

    @Autowired
    private AirlinesRepo airlinesRepo;

    private static final Logger logger = LoggerFactory.getLogger(AirlinesServiceImpl.class);


    @Override
    public AirlinesEntity createAirlines(AirlinesEntity airlinesEntity) {
        AirlinesEntity savedEntity = new AirlinesEntity();
        try {
            airlinesEntity.setName(airlinesEntity.getName().toUpperCase());
            savedEntity = airlinesRepo.save(airlinesEntity);

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return savedEntity;
    }

    @Override
    public List<AirlinesEntity> findAirlines() {
        List<AirlinesEntity> list = new ArrayList<>();
        try {
            list = airlinesRepo.findAll();

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return list;
    }
}
