package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.repository.ServiceRepository;
import com.malina.siteForInteriorDesigner.service.ServiceService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceServiceImpl implements ServiceService {
    public final ServiceRepository repository;

    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    @ResponseBody
    public List<ServiceEntity> findAllService() {
        return repository.findAll();
    }

    @Override
    public ServiceEntity findServiceById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ServiceEntity addService(ServiceEntity service) {
        return repository.save(service);
    }

    @Override
    public ServiceEntity updateService(ServiceEntity service) {
        return repository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        repository.deleteById(id);
    }
}
