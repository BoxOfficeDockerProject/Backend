package dev.movie.boxoffice.repository;


import dev.movie.boxoffice.entity.FavMovie;
import dev.movie.boxoffice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FavMovieRepository extends JpaRepository<FavMovie, Long> {
   List<FavMovie> findByUser(User userId);

   @Query(
           nativeQuery = true,
           value = "select * from movie_table \n" +
                   "where movie_cd = :movieCd and user_id= :userId"
   )
   Boolean checkMovie(String movieCd, User userId);

//   Boolean findByMovieCd(String movieCd);
//   Boolean findByUserId(User userId);

}
