package dev.movie.boxoffice.mainApi;

import dev.movie.boxoffice.mainApi.dto.MemberDto;
import dev.movie.boxoffice.mainApi.entity.Member;
import dev.movie.boxoffice.mainApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberDto createUser(MemberDto dto) {
        Member member = Member.builder()
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .build();
        Member result = memberRepository.save(member);

        MemberDto memberDto = MemberDto.builder()
                .memberId(result.getMemberId())
                .nickName(result.getNickName())
                .password(result.getPassword())
                .build();
        return memberDto;
    }

    @Override
    @Transactional
    public List<MemberDto> readAllUser() {
        return memberRepository.findAll().stream()
                .map(member -> MemberDto.builder()
                        .memberId(member.getMemberId())
                        .nickName(member.getNickName())
                        .password(member.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
