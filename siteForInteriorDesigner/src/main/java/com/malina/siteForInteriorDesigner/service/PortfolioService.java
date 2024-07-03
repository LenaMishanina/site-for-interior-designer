package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PortfolioService {
    public List<PortfolioEntity> findAllImage();
    public PortfolioEntity addImage(PortfolioEntity image);
    PortfolioEntity getImageById(long id);
    void deleteImage(long id);
    PortfolioEntity updateImage(PortfolioEntity image);
}
