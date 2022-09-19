package dev.movie.boxoffice.mainApi;

import dev.movie.boxoffice.mainApi.dto.MemberDto;

import java.util.List;

public interface MemberService {

    MemberDto createUser(MemberDto dto);
    List<MemberDto> readAllUser();

}
