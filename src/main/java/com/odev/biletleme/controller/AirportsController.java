package com.odev.biletleme.controller;

import com.odev.biletleme.common.CommonResponse;
import com.odev.biletleme.entity.AirlinesEntity;
import com.odev.biletleme.entity.AirportsEntity;
import com.odev.biletleme.mapper.AirportsMapper;
import com.odev.biletleme.model.AirportDto;
import com.odev.biletleme.services.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/airports")
public class AirportsController {

    private static final Logger logger = LoggerFactory.getLogger(AirportsController.class);

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportsMapper airportsMapper;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public CommonResponse<AirlinesEntity> getAllAirport() {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        AirportDto airportDto = new AirportDto();
        List<AirportDto> airportDtoList = new ArrayList<>();
        try {
            List<AirportsEntity> airportsEntities = airportService.findAllAirports();
            for (AirportsEntity airlinesEntity : airportsEntities) {
                airportDto = airportsMapper.entityToDto(airlinesEntity);
                airportDtoList.add(airportDto);
            }
            commonResponse.setResult(airportDtoList);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResponse<AirlinesEntity> createAirlines(@RequestBody AirportDto airportDto) {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        try {
            AirportsEntity saved = airportService.createAirport(airportsMapper.dtoToEntity(airportDto));
            commonResponse.setResult(airportsMapper.entityToDto((saved)));
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }


}
