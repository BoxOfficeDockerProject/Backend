package dev.movie.boxoffice.movieApi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
//영화목록 검색
//Request / Response 모델 값들 전부 들어가져 있어야 함
public class MovieListModel {

    @Getter
    @Setter
    static public class MovieListRequest{
        private String curPage; //현재 페이지 지정
        private String itemPerPage; //결과 row의 갯수
        private String movieNm; //영화명(국문)
        private String directorNm; //감독명
        private String openStartDt; //조회시작 개봉연도
        private String openEndDt; //조회 종료 개봉연도
        private String prdtStartYear; //조회시작 제작연도
        private String prdtEndYear; //조회종료 제작연도
        private String repNationCd; //국적코드 * 추가옵션
        private String movieTypeCd; //영화유형코드 * 추가옵션
    }

    @Getter
    @Setter
    static public class MovieListResponse
    {
        private MovieListResult movieListResult;
    }

    @Getter
    @Setter  //결과값
    static public class MovieListResult
    {
        private int totCnt;
        private String source;
        private ArrayList<Movie> movieList;
    }

    @Getter
    @Setter
    static public class Movie
    {
        private String movieCd; //영화코드
        private String movieNm; //영화명
        private String movieNmEn; //영화명(영문)
        private String prdtYear; //제작연도
        private String openDt; // 개봉일
        private String typeNm; //영화유형
        private String prdtStatNm; //제작상태
        private String nationAlt; //제작국가 전체
        private String genreAlt; //영화장르
        private String repNationNm; //대표 제작국가명
        private String repGenreNm; //대표 장르명
        private ArrayList<Director> directors; //영화감독
        private ArrayList<Company> companys; //제작사
    }

    @Getter
    @Setter
    static public class Director //영화감독이 다수이기 때문에
    {
        private String peopleNm;
    }

    @Getter
    @Setter
    static public class Company // Company안에  Cd,Nm 포함되어있음
    {
        private String companyCd;
        private String companyNm;
    }
}
