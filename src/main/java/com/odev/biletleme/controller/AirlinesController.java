package com.odev.biletleme.controller;

import com.odev.biletleme.common.CommonResponse;
import com.odev.biletleme.entity.AirlinesEntity;
import com.odev.biletleme.mapper.AirlinesMapper;
import com.odev.biletleme.model.AirlinesDto;
import com.odev.biletleme.services.AirlinesService;
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
@RequestMapping(value = "/airlines")
public class AirlinesController {

    private static final Logger logger = LoggerFactory.getLogger(AirlinesController.class);

    @Autowired
    private AirlinesService airlinesService;

    @Autowired
    private AirlinesMapper airlinesMapper;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public CommonResponse<AirlinesEntity> getAllAirlines() {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        AirlinesDto airlinesDto = new AirlinesDto();
        List<AirlinesDto> airlinesDtoList = new ArrayList<>();
        try {
            List<AirlinesEntity> airlinesEntities = airlinesService.findAirlines();
            for (AirlinesEntity airlinesEntity : airlinesEntities) {
                airlinesDto = airlinesMapper.entityToDto(airlinesEntity);
                airlinesDtoList.add(airlinesDto);
            }
            commonResponse.setResult(airlinesDtoList);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResponse<AirlinesEntity> createAirlines(@RequestBody AirlinesDto airlinesDto) {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        try {
            AirlinesEntity saved = airlinesService.createAirlines(airlinesMapper.dtoToEntity(airlinesDto));
            commonResponse.setResult(airlinesMapper.entityToDto(saved));
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }

/*    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public CommonResponse<AirlinesEntity> getAirlinesByName(@PathVariable(value = "name", required = true) String name) {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        try {
            AirlinesEntity airlinesEntity = airlinesRepo.findByName(name);
            commonResponse.setResult(airlinesEntity);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }*/

/*    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public CommonResponse<AirlinesEntity> getAirlinesById(@PathVariable(value = "id", required = true) Long id) {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        try {
            AirlinesEntity airlinesEntity = airlinesRepo.findAirlinesEntityByAirlinesID(id);
            commonResponse.setResult(airlinesEntity);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }*/



/*    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResponse<AirlinesEntity> deleteAirlines(@RequestBody AirlinesEntity airlinesEntity) {
        CommonResponse<AirlinesEntity> commonResponse = new CommonResponse<>();
        try {
            airlinesRepo.delete(airlinesEntity);
            commonResponse.setResultInfo("Record Deleted");
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;

    }*/

}
