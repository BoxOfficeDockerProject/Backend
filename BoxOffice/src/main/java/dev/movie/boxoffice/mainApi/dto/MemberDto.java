package dev.movie.boxoffice.mainApi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long memberId;
    private String nickName;
    private String password;

    @Builder
    public MemberDto(Long memberId, String nickName, String password) {
        this.memberId = memberId;
        this.nickName = nickName;
        this.password = password;
    }
}
