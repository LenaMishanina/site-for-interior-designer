package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.exception.ImageNotFoundException;
import com.malina.siteForInteriorDesigner.repository.PortfolioRepository;
import com.malina.siteForInteriorDesigner.service.PortfolioService;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository repository;

    public PortfolioServiceImpl(PortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioEntity getImage(String filename) {
        return repository.findByFilename(filename)
                .orElseThrow(ImageNotFoundException::new);
    }
}
