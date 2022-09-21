package dev.movie.boxoffice.service;
import dev.movie.boxoffice.dto.UserDto;
import dev.movie.boxoffice.entity.User;
import dev.movie.boxoffice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository memberRepository;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDto signupUser(UserDto dto) {
        User member = User.builder()
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .build();
        User result = memberRepository.save(member);

        UserDto memberDto = UserDto.builder()
                .userId(result.getUserId())
                .userName(result.getUserName())
                .password(result.getPassword())
                .build();
        return memberDto;
    }

    @Override
    @Transactional
    public List<UserDto> readAllUser() {
        return memberRepository.findAll().stream()
                .map(member -> UserDto.builder()
                        .userId(member.getUserId())
                        .userName(member.getUserName())
                        .password(member.getPassword())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserDto readUser(Long userId) {
        if (!memberRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<User> userOptional = memberRepository.findById(userId);

        UserDto userDto = UserDto.builder()
                .userId(userOptional.get().getUserId())
                .userName(userOptional.get().getUserName())
                .build();
        return userDto;
    }



    @Override
    public UserDto loginUser(String userName, String password) {

        Optional<User> userOptional = memberRepository.findByUserName(userName);

        if(!userOptional.get().getPassword().equals(password))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        UserDto userDto = UserDto.builder()
                .userId(userOptional.get().getUserId())
                .userName(userOptional.get().getUserName())
                .build();
        return userDto;
    }


}
