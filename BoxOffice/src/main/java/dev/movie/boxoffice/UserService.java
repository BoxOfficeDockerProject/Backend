package dev.movie.boxoffice;


import dev.movie.boxoffice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto);
    List<UserDto> readAllUser();

}
