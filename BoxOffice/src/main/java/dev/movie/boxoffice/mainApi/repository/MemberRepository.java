package dev.movie.boxoffice.mainApi.repository;

import dev.movie.boxoffice.mainApi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
