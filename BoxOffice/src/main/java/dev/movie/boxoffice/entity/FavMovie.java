package dev.movie.boxoffice.entity;
import lombok.Builder;
import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String audiAcc;
    private String thumbnail;
    private Float rating; //쿼리로 평점 결과값

    @NotNull(message = "댓글을 작성해주세요 NOT NULL")
    private String comment;
    @NotNull(message = "점수를 작성해주세요 NOT NULL")
    private Integer userRating;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = User.class
    )
    @JoinColumn(name = "user_id")
    private User user;


    protected FavMovie() {
    }

    @Builder
    public FavMovie(Long movieSeq, String movieCd, String movieNm, String openDt, String audiAcc, String thumbnail, Float rating, String comment, Integer userRating, User user) {
        this.movieSeq = movieSeq;
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAcc = audiAcc;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.comment = comment;
        this.userRating = userRating;
        this.user = user;
    }
}
