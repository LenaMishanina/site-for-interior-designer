package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.service.ServiceService;
import com.malina.siteForInteriorDesigner.service.impl.ServiceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    private final ServiceServiceImpl service;

    public ServiceController(ServiceServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public List<ServiceEntity> findAllService() {
        return service.findAllService();
    }

}
