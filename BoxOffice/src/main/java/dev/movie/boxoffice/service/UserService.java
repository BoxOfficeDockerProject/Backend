package dev.movie.boxoffice.service;


import dev.movie.boxoffice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto);
    List<UserDto> readAllUser();
    UserDto readUser(Long userId);

}
