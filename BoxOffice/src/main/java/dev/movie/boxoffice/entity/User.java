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
    @Column(name = "user_seq")
    private Long userSeq;
    @NotNull(message = "userId NotNULL")
    private String userId;
    @NotNull(message = "userPassword NotNULL")
    private String password;

    protected User() {
    }

    @Builder
    public User(Long userSeq, String userId, String password) {
        this.userSeq = userSeq;
        this.userId = userId;
        this.password = password;
    }
}
