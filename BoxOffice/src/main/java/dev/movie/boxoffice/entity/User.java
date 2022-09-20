package dev.movie.boxoffice.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;
    @NotNull
    private String userId;
    @NotNull
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
