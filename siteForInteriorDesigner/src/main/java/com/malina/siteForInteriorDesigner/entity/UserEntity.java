package com.malina.siteForInteriorDesigner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @PersistenceConstructor
    public UserEntity(Long id, String first_name, String last_name, String email, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {

    }

    public static UserEntity off(String first_name, String last_name, String email, String password){
        return new UserEntity(null, first_name, last_name, email, password);
    }
}
