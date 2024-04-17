package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<ServiceEntity> findAllService();
    Optional<ServiceEntity> findById(Long id);
    ServiceEntity saveService(ServiceEntity service);
    ServiceEntity updateService(ServiceEntity service);
    void deleteService(Long id);
}
