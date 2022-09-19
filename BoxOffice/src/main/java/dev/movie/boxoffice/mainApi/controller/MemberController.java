package dev.movie.boxoffice.mainApi.controller;

import dev.movie.boxoffice.mainApi.MemberServiceImpl;
import dev.movie.boxoffice.mainApi.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("api/v1/user")
public class MemberController {
    private final MemberServiceImpl memberService;

    @PostMapping()
    public ResponseEntity<MemberDto> createUser(@RequestBody MemberDto dto){
        MemberDto result = this.memberService.createUser(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<List<MemberDto>> readAllUser(){
        List<MemberDto> memberList = this.memberService.readAllUser();
        if (memberList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(memberList);
    }

}
