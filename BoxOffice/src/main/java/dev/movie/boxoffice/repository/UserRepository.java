package dev.movie.boxoffice.repository;


import dev.movie.boxoffice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
