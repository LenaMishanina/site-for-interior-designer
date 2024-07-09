package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<ServiceEntity> findAllService();
    ServiceEntity findServiceById(Long id);
    ServiceEntity addService(ServiceEntity service);
    ServiceEntity updateService(ServiceEntity service);
    void deleteService(Long id);
}
