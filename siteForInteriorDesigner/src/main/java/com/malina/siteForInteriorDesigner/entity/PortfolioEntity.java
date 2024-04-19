package com.malina.siteForInteriorDesigner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "filename", unique = true)
    private String filename;
    @Column(name = "mime_type")
    private String mime_type;
    @Column(name = "data")
    private byte[] data;

    public PortfolioEntity() {
    }

    public PortfolioEntity(Long id, String filename, String mime_type, byte[] data) {
        this.id = id;
        this.filename = filename;
        this.mime_type = mime_type;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
