package dev.movie.boxoffice.entity;


import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @NotNull(message = "userName NotNULL")
    private String userName;
    @NotNull(message = "userPassword NotNULL")
    private String password;

    protected User() {
    }

    @Builder
    public User(Long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}
