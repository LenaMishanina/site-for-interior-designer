package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.repository.ServiceRepository;
import com.malina.siteForInteriorDesigner.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceServiceImpl implements ServiceService {
    public final ServiceRepository repository;

    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceEntity> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ServiceEntity saveEmployee(ServiceEntity service) {
        return repository.save(service);
    }

    @Override
    public ServiceEntity updateEmployee(ServiceEntity service) {
        return repository.save(service);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
