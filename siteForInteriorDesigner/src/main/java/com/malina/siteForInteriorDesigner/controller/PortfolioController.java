package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.service.PortfolioService;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {
    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }
    @GetMapping("/portfolio/{filename}")
    public ResponseEntity<Resource> retrieve(@PathVariable String filename) {
        PortfolioEntity image = service.getImage(filename);
        ByteArrayResource body = new ByteArrayResource(image.getData());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, image.getMime_type()).body(body);
    }
}
