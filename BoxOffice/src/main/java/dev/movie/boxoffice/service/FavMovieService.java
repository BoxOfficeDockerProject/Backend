package dev.movie.boxoffice.service;

import dev.movie.boxoffice.dto.FavMovieDto;

import java.util.List;

public interface FavMovieService {

    FavMovieDto createFvMovie(Long userSeq, FavMovieDto dto);
    List<FavMovieDto> readAllFvMovie();
    List<FavMovieDto> readUserFvMovie(Long userSeq);
    FavMovieDto updateFvMovie(Long userSeq, Long movieSeq, FavMovieDto dto);
    Boolean deleteFvMovie(Long userSeq, Long movieSeq);

}
