package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.repository.PortfolioRepository;
import com.malina.siteForInteriorDesigner.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Slf4j
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository repository;
    @Autowired
    public PortfolioServiceImpl(PortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    @ResponseBody
    public List<PortfolioEntity> findAllImage() {
        return repository.findAll();
    }

    @Override
    public PortfolioEntity addImage(PortfolioEntity image) {
        return repository.save(image);
    }

    @Override
    public PortfolioEntity getImageById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteImage(long id) {
        repository.deleteById(id);
    }

    @Override
    public PortfolioEntity updateImage(PortfolioEntity image) {
        return repository.save(image);
    }


}
