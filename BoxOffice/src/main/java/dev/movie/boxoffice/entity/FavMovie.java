package dev.movie.boxoffice.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "movieTable")
public class FavMovie extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_seq")
    private Long movieSeq;
    private String movieCd;
    private String movieNm;
    private String openDt; //openAPI 그대로 가져오는거면 String
    private String audiAdd;
    private String thumbnail;
    private Float rating; //쿼리로 평점 결과값

    @NotNull
    private String comment;
    @NotNull
    private Integer userRating;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = User.class
    )
    @JoinColumn(name = "userId")
    private User user;


    protected FavMovie() {
    }

    @Builder
    public FavMovie(Long movieSeq, String movieCd, String movieNm, String openDt, String audiAdd, String thumbnail, Float rating, String comment, Integer userRating, User user) {
        this.movieSeq = movieSeq;
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAdd = audiAdd;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.comment = comment;
        this.userRating = userRating;
        this.user = user;
    }
}
