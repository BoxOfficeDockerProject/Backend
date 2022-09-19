package dev.movie.boxoffice.movieApi.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.movie.boxoffice.movieApi.model.BoxOfficeModel;
import dev.movie.boxoffice.movieApi.model.MovieListModel;
import dev.movie.boxoffice.movieApi.util.Utility;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
//공공데이터 API 통신 및 모델 바인딩
public class BoxOffice {
    static String _url = "http://kobis.or.kr";
    static final String _key = "{accessKey}";

    //API : 일일 박스오피스
    public BoxOfficeModel.BoxOfficeResponse DailyBoxOffice(BoxOfficeModel.BoxOfficeRequest  boxOfficeRequest, String targetDt) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        String result = "";
        BoxOfficeModel.BoxOfficeResponse response= null;

        params.add("key", _key); //필수
        params.add("targetDt", targetDt); //필수
        result = Utility.GetHttp(_url, urlPath, params);
        response = objectMapper.readValue(result,  BoxOfficeModel.BoxOfficeResponse.class);
        return response;
    }

    //API : 영화목록
    public MovieListModel.MovieListResponse SearchMovieList(MovieListModel.MovieListRequest movieListRequest,
                                                            String targetDt, String movieNm) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieList.json";
        String result = "";
        MovieListModel.MovieListResponse response= null;

        params.add("key", _key);
        params.add("targetDt", targetDt);
        params.add("movieNm", movieNm);
        params.add("repNationCd", movieListRequest.getRepNationCd()); //* 추가옵션 반영
        params.add("movieTypeCd", movieListRequest.getMovieTypeCd()); //* 추가옵션 반영

        result = Utility.GetHttp(_url, urlPath, params);
        response = objectMapper.readValue(result, MovieListModel.MovieListResponse.class);
        return response;
    }



}
