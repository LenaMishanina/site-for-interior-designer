package com.malina.siteForInteriorDesigner.entity;

import com.malina.siteForInteriorDesigner.Data.Token;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;
    @Column(name = "first_name")
    @Getter @Setter
    private String first_name;
    @Column(name = "last_name")
    @Getter @Setter
    private String last_name;
    @Column(name = "email")
    @Getter @Setter
    private String email;
    @Column(name = "password")
    @Getter @Setter
    private String password;

//    @MappedCollection private final Set<Token> tokens = new HashSet<>();

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
