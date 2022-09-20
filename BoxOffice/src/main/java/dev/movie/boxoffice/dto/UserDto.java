package dev.movie.boxoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userSeq;
    private String userId;
    private String password;

    @Builder
    public UserDto(Long userSeq, String userId, String password) {
        this.userSeq = userSeq;
        this.userId = userId;
        this.password = password;
    }
}
