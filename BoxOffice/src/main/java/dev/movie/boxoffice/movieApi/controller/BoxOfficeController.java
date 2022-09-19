package dev.movie.boxoffice.movieApi.controller;
import dev.movie.boxoffice.movieApi.model.BoxOfficeModel;
import dev.movie.boxoffice.movieApi.model.MovieListModel;
import dev.movie.boxoffice.movieApi.service.BoxOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/*
 * 영화박스오피스 DB (일 3000회 제한)
 * 일별 박스오피스 - /rest/boxoffice/searchDailyBoxOfficeList
 * 주간/주말 박스오피스 - /rest/boxoffice/searchWeeklyBoxOfficeLis
 * 공통코드 조회
 * 영화목록 - /rest/movie/searchMovieList
 * 영화 상세정보 -/rest/movie/searchMovieInfo
 * 영화사목록 - /rest/company/searchCompanyList
 * 영화사 상세정보 - rest/company/searchCompanyInfo
 * 영화인목록 - /rest/people/searchPeopleList
 * 영화인 상세정보 - /rest/people/searchPeopleInfo
 */

@RestController
@RequestMapping("/api/boxoffice/*")
//RestAPI 컨트롤러
public class BoxOfficeController {
    @Autowired
    private BoxOfficeService boxOfficeService;

    //일일 박스오피스
    @RequestMapping("/daily")
    public HashMap<String, BoxOfficeModel.BoxOfficeResponse> BoxOffice(@RequestParam String targetDt)
    {
        HashMap<String, BoxOfficeModel.BoxOfficeResponse> result;
        result = boxOfficeService.BoxOfficeDailySearch(targetDt);
        return result;
    }

    //영화이름 조회
    @RequestMapping("/searchName")
    public HashMap<String, MovieListModel.MovieListResponse> SearchBoxOfficeName(@RequestParam String targetDt,
                                                                                 @RequestParam String movieNm)
    {
        HashMap<String, MovieListModel.MovieListResponse> result;
        result = boxOfficeService.SearchName(targetDt, movieNm);
        return result;
    }



}
