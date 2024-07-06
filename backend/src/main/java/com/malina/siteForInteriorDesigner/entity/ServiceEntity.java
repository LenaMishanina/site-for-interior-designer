package com.malina.siteForInteriorDesigner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//=primary key
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "short_description")
    private String short_description;
    @Column(name = "long_description")
    private String long_description;
    @Column(name = "price")
    private Long price;
    @Column(name = "value_measure")
    private String value_measure;

    public ServiceEntity() {
    }

    public ServiceEntity(Long id, String name, String short_description, String long_description, Long price, String value_measure) {
        this.id = id;
        this.name = name;
        this.short_description = short_description;
        this.long_description = long_description;
        this.price = price;
        this.value_measure = value_measure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getValue_measure() {
        return value_measure;
    }

    public void setValue_measure(String value_measure) {
        this.value_measure = value_measure;
    }
}
