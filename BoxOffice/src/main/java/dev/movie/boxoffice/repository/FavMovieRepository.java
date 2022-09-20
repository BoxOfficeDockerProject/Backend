package dev.movie.boxoffice.repository;


import dev.movie.boxoffice.entity.FavMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavMovieRepository extends JpaRepository<FavMovie, Long> {

}
