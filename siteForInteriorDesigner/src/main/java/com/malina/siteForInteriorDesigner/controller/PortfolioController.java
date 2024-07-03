package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PortfolioController {
    private final PortfolioService service;
    @Autowired
    public PortfolioController(PortfolioService service) {
        this.service = service;
    }
    @GetMapping("/portfolio")
    public List<PortfolioEntity> getPortfolio() {
        return service.findAllImage();
    }
    @PostMapping("/portfolio/add")
    public String addImage(@RequestBody PortfolioEntity image) {
        service.addImage(image);
        return "Image was added successfully...";
    }
    @GetMapping("/portfolio/{id}")
    public PortfolioEntity getImageById(@PathVariable("id") long id){
        return service.getImageById(id);
    }
    @PutMapping("/portfolio")
    public PortfolioEntity updateImage(@RequestBody PortfolioEntity image) {
        return service.updateImage(image);
    }
    @DeleteMapping("/portfolio/{id}")
    public String deleteImage(@PathVariable("id") long id){
        service.deleteImage(id);
        return "Image was removed successfully...";
    }


}
