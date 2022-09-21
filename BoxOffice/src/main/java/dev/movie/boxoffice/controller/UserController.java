package dev.movie.boxoffice.controller;

import dev.movie.boxoffice.service.UserServiceImpl;
import dev.movie.boxoffice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController()
@RequestMapping("api/v1/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl memberService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUpUser(@RequestBody UserDto dto){
        UserDto result = this.memberService.signupUser(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> readAllUser(){
        List<UserDto> memberList = this.memberService.readAllUser();
        if (memberList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(memberList);
    }

    @GetMapping()
    public ResponseEntity<UserDto> readUser(@RequestParam Long userId){
        UserDto result = this.memberService.readUser(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestParam String userName,
                                             @RequestParam String password){
       UserDto result = this.memberService.loginUser(userName, password);
       return ResponseEntity.ok(result);
    }


}
