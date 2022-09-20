package dev.movie.boxoffice;

import dev.movie.boxoffice.dto.FavMovieDto;

import java.util.List;

public interface FavMovieService {

    FavMovieDto createFvMovie(Long userSeq, FavMovieDto dto);
    List<FavMovieDto> readAllFvMovie();
    FavMovieDto updateFvMovie(Long userSeq, Long movieSeq, FavMovieDto dto);
    Boolean deleteFvMovie(Long userSeq, Long movieSeq);

}
