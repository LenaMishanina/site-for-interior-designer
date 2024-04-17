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

}
