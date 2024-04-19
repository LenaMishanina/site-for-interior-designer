package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import org.springframework.stereotype.Service;

@Service
public interface PortfolioService {
    PortfolioEntity getImage(String filename);
}
