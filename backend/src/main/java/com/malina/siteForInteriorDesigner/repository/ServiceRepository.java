package com.malina.siteForInteriorDesigner.repository;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
