package com.malina.siteForInteriorDesigner.repository;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {
}
