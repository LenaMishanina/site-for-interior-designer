package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<ServiceEntity> findAllEmployee();
    Optional<ServiceEntity> findById(Long id);
    ServiceEntity saveEmployee(ServiceEntity service);
    ServiceEntity updateEmployee(ServiceEntity service);
    void deleteEmployee(Long id);
}
