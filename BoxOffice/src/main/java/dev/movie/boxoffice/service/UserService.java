package dev.movie.boxoffice.service;


import dev.movie.boxoffice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto signupUser(UserDto dto);
    List<UserDto> readAllUser();
    UserDto readUser(Long userId);
    UserDto loginUser(String userName, String password);

}
