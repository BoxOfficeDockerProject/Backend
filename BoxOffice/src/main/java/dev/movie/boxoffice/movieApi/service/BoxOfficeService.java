package dev.movie.boxoffice.movieApi.service;
import dev.movie.boxoffice.movieApi.config.BoxOffice;
import dev.movie.boxoffice.movieApi.model.BoxOfficeModel;
import dev.movie.boxoffice.movieApi.model.MovieListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
//공공데이터 API Response 가공
public class BoxOfficeService {
    @Autowired
    private BoxOffice boxOffice;

    // 일일 박스오피스
    public HashMap<String, BoxOfficeModel.BoxOfficeResponse> BoxOfficeDailySearch(String targetDt){
        BoxOfficeModel.BoxOfficeRequest boxOfficeRequest = new BoxOfficeModel.BoxOfficeRequest();
        BoxOfficeModel.BoxOfficeResponse boxOfficeResponse = null;
        HashMap<String, BoxOfficeModel.BoxOfficeResponse> result = new HashMap<>();
        try {
            boxOfficeResponse = boxOffice.DailyBoxOffice(boxOfficeRequest, targetDt);
            result.put("dailyBoxOfficeList", boxOfficeResponse);
        }catch (Exception e){
        }
        return result;
    }

    //영화이름 조회
    public HashMap<String, MovieListModel.MovieListResponse> SearchName(String targetDt, String movieNm)
    {
        MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        MovieListModel.MovieListResponse movieListResponse = null;
        HashMap<String, MovieListModel.MovieListResponse> result = new HashMap<>();

        try{
            movieListResponse = boxOffice.SearchMovieList(movieListRequest, targetDt ,movieNm);
            result.put("MovieList", movieListResponse);
        }catch (Exception e){
        }
        return result;
    }


}
