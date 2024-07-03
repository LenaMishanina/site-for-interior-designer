package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {
    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }
    @GetMapping("/service")
    public List<ServiceEntity> findAllService() {
        return service.findAllService();
    }
    @PostMapping("/service/add")
    public String addService(@RequestBody ServiceEntity ser) {
        service.addService(ser);
        return "Service was added successfully...";
    }
    @GetMapping("/service/{id}")
    public ServiceEntity getServiceById(@PathVariable("id") long id){
        return service.findServiceById(id);
    }
    @PutMapping("/service")
    public ServiceEntity updateService(@RequestBody ServiceEntity ser) {
        return service.updateService(ser);
    }
    @DeleteMapping("/service/{id}")
    public String deleteService(@PathVariable("id") long id){
        service.deleteService(id);
        return "Service was removed successfully...";
    }

}
