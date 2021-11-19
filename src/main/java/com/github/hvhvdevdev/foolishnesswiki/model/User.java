package com.github.hvhvdevdev.foolishnesswiki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user__")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private Role role;


    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public enum Role {
        ADMIN, WRITER, READER;
    }
}
