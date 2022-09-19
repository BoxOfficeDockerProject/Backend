package dev.movie.boxoffice.movieApi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

//일일 박스 오피스
public class BoxOfficeModel {

    @Getter
    @Setter //요청
    static public class BoxOfficeRequest{
        private String itemPerPage; //결과 row의 갯수
        private String multiMovieYn; //“Y” : 다양성 영화 “N” : 상업영화
        private String repNationCd; //“K: : 한국영화 “F” : 외국영화
        private String wideAreaCd; //상영지역별로 조회
    }

    @Getter
    @Setter //응답
    static public class BoxOfficeResponse
    {
        private BoxOfficeResult boxOfficeResult;
    }

    @Getter
    @Setter  //결과값
    static public class BoxOfficeResult
    {
        private String boxofficeType;
        private String showRange;
        private ArrayList<Movie> dailyBoxOfficeList;
    }

    @Getter
    @Setter
    static public class Movie
    {
        private String rnum;
        private String rank;
        private String rankInten;
        private String rankOldAndNew;
        private String movieCd;
        private String movieNm;
        private String openDt;
        private String salesAmt;
        private String salesShare;
        private String salesInten;
        private String salesChange;
        private String salesAcc;
        private String audiCnt;
        private String audiInten;
        private String audiChange;
        private String audiAcc;
        private String scrnCnt;
        private String showCnt;
    }


}
