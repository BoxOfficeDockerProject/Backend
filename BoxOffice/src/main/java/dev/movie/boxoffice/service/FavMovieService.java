package dev.movie.boxoffice.service;

import dev.movie.boxoffice.dto.FavMovieDto;

import java.util.List;

public interface FavMovieService {

    FavMovieDto createFvMovie(Long userId, FavMovieDto dto);
    List<FavMovieDto> readAllFvMovie();
    List<FavMovieDto> readUserFvMovie(Long userId);
    FavMovieDto updateFvMovie(Long userId, Long movieSeq, FavMovieDto dto);
    Boolean deleteFvMovie(Long userId, Long movieSeq);

}
