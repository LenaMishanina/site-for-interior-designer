package com.malina.siteForInteriorDesigner.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "portfolio")
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "path")
    private String path;

    @Column(name = "index")
    private Integer index;

    public PortfolioEntity() {
    }

    public PortfolioEntity(Long id, String path, Integer index) {
        this.id = id;
        this.path = path;
        this.index = index;
    }

    public PortfolioEntity(String path, Integer index) {
        this.path = path;
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
