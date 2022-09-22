package dev.movie.boxoffice.entity;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
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
    @Column(name = "user_name", unique = true)
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
