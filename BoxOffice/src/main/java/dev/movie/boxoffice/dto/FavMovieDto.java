package dev.movie.boxoffice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
public class FavMovieDto {
    private Long movieSeq;
    private String movieCd;
    private String movieNm;
    private String openDt;
    private String audiAcc;
    private String thumbnail;
    private Float rating;
    private String comment;
    private Integer userRating;
    private UserDto userDto;

    private Instant createAt;//생성시간 todo: 이부분 해결해야함
    private Instant update; //수정시간

    @Builder
    public FavMovieDto(Long movieSeq, String movieCd, String movieNm, String openDt, String audiAcc, String thumbnail, Float rating, String comment, Integer userRating, UserDto userDto, Instant createAt, Instant update) {
        this.movieSeq = movieSeq;
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAcc = audiAcc;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.comment = comment;
        this.userRating = userRating;
        this.userDto = userDto;
        this.createAt = createAt;
        this.update = update;
    }
}
