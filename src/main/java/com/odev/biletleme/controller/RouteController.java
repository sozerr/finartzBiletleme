package com.odev.biletleme.controller;

import com.odev.biletleme.common.CommonResponse;
import com.odev.biletleme.entity.RouteEntity;
import com.odev.biletleme.mapper.RouteMapper;
import com.odev.biletleme.model.RouteDTO;
import com.odev.biletleme.services.RouteService;
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
@RequestMapping(value = "/route")
public class RouteController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteMapper routeMapper;

    CommonResponse<RouteEntity> commonResponse = new CommonResponse<>();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResponse<RouteEntity> createRoute(@RequestBody RouteDTO routeDTO) {
        try {
            RouteEntity saved = routeService.createRoute(routeMapper.dtoToEntity(routeDTO));
            if (saved.getRouteID() == 0 || saved.getRouteID() == null) {
                commonResponse.setResultInfo("Route did not create");
                throw new Exception();
            } else {
                commonResponse.setSuccess(true);
                commonResponse.setResult(routeMapper.entityToDto(saved));
            }
        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public CommonResponse<RouteEntity> getAllRoute() {
        List<RouteDTO> dtoList = new ArrayList<>();
        RouteDTO dto = new RouteDTO();
        try {
            List<RouteEntity> list = routeService.getAllRoute();
            if (list.isEmpty()) {
                commonResponse.setResultInfo("Route Not Found!");
            } else {
                for (RouteEntity routeEntity : list) {
                    dto = routeMapper.entityToDto(routeEntity);
                    dtoList.add(dto);
                }
            }

            commonResponse.setResult(dtoList);
            commonResponse.setSuccess(true);

        } catch (Exception e) {
            logger.error(e.toString());
            commonResponse.setError("ERROR");
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }

}
