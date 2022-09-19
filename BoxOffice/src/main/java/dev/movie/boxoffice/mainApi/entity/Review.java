package dev.movie.boxoffice.mainApi.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private String reviewId;
    private String movieCd;
    private Long stars; //평점
    private Long like; //좋아요
    private String review; //리뷰내용



}
