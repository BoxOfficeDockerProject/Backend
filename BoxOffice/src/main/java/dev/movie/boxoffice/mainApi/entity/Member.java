package dev.movie.boxoffice.mainApi.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    private String nickName; //중복 불가능
    private String password;

    protected Member() {
    }

    @Builder
    public Member(Long memberId, String nickName, String password) {
        this.memberId = memberId;
        this.nickName = nickName;
        this.password = password;
    }
}
