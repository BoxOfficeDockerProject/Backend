package dev.movie.boxoffice.service;
import dev.movie.boxoffice.dto.FavMovieDto;
import dev.movie.boxoffice.dto.UserDto;
import dev.movie.boxoffice.entity.FavMovie;
import dev.movie.boxoffice.entity.User;
import dev.movie.boxoffice.repository.FavMovieRepository;
import dev.movie.boxoffice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional   //default -
public class FavMovieServiceImpl implements FavMovieService {
    Logger logger = LoggerFactory.getLogger(FavMovieServiceImpl.class);
    private final FavMovieRepository favMovieRepository;
    private final UserRepository userRepository;

    @Override
    public FavMovieDto createFvMovie(Long userId, FavMovieDto dto) {
        if (!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();

        User userTrans = User.builder()
                .userId(userId)
                .build();

        if (favMovieRepository.checkMovie(dto.getMovieCd(), userTrans)!= null) {
            return null;
        }
        else {
            FavMovie favMovie = FavMovie.builder()
                    .movieSeq(dto.getMovieSeq())
                    .movieCd(dto.getMovieCd())
                    .movieNm(dto.getMovieNm())
                    .openDt(dto.getOpenDt())
                    .audiAcc(dto.getAudiAcc())
                    .thumbnail(dto.getThumbnail())
                    .rating(dto.getRating())
                    .comment(dto.getComment())
                    .userRating(dto.getUserRating())
                    .user(User.builder()
                            .userId(userId)
                            .build())
                    .build();

            FavMovie result = this.favMovieRepository.save(favMovie);

            FavMovieDto favMovieDto = FavMovieDto.builder()
                    .movieSeq(result.getMovieSeq())
                    .movieCd(result.getMovieCd())
                    .movieNm(result.getMovieNm())
                    .openDt(result.getOpenDt())
                    .audiAcc(result.getAudiAcc())
                    .thumbnail(result.getThumbnail())
                    .rating(result.getRating())
                    .comment(result.getComment())
                    .userRating(result.getUserRating())
                    .createAt(result.getCreateAt())  //todo: 시간 안나옴
                    .update(result.getUpdateAt())
                    .userDto(UserDto.builder()
                            .userId(user.getUserId())
                            .userName(user.getUserName())
                            .build())
                    .build();
            return favMovieDto;

        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<FavMovieDto> readAllFvMovie() {
        if (favMovieRepository.findAll().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return favMovieRepository.findAll().stream()
                .map(favMovie -> FavMovieDto.builder()
                        .movieSeq(favMovie.getMovieSeq())
                        .movieCd(favMovie.getMovieCd())
                        .movieNm(favMovie.getMovieNm())
                        .openDt(favMovie.getOpenDt())
                        .audiAcc(favMovie.getAudiAcc())
                        .thumbnail(favMovie.getThumbnail())
                        .rating(favMovie.getRating())
                        .comment(favMovie.getComment())
                        .userRating(favMovie.getUserRating())
                        .createAt(favMovie.getCreateAt())
                        .update(favMovie.getUpdateAt())
                        .build())
                .collect(Collectors.toList());
    }

    //fk 유저로 조회
    @Override
    @Transactional(readOnly = true)
    public List<FavMovieDto> readUserFvMovie(Long userId) {
        if (!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        User userTrans = User.builder()
                .userId(userId)
                .build();

        return favMovieRepository.findByUser(userTrans).stream()
                .map(favMovie ->FavMovieDto.builder()
                        .movieSeq(favMovie.getMovieSeq())
                        .movieCd(favMovie.getMovieCd())
                        .movieNm(favMovie.getMovieNm())
                        .openDt(favMovie.getOpenDt())
                        .audiAcc(favMovie.getAudiAcc())
                        .thumbnail(favMovie.getThumbnail())
                        .rating(favMovie.getRating())
                        .comment(favMovie.getComment())
                        .userRating(favMovie.getUserRating())
                        .createAt(favMovie.getCreateAt())
                        .update(favMovie.getUpdateAt())
                        .userDto(UserDto.builder()
                                .userId(userId)
                                .build())
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public FavMovieDto updateFvMovie(Long userId, Long movieSeq, FavMovieDto dto) {
        if (!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Optional<User> userOptional = userRepository.findById(userId);

        Optional<FavMovie> favMovieOptional = favMovieRepository.findById(movieSeq);
        if (!favMovieOptional.get().getMovieSeq().equals(movieSeq))
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);

        FavMovie favMovie = FavMovie.builder()
                .movieSeq(favMovieOptional.get().getMovieSeq())
                .movieCd(dto.getMovieCd())
                .movieNm(dto.getMovieNm())
                .openDt(dto.getOpenDt())
                .audiAcc(dto.getAudiAcc())
                .thumbnail(dto.getThumbnail())
                .rating(dto.getRating())
                .comment(dto.getComment())
                .userRating(dto.getUserRating())
                .user(User.builder()
                        .userId(userId)
                        .build())
                .build();
        FavMovie result = this.favMovieRepository.save(favMovie);

        FavMovieDto favMovieDto = FavMovieDto.builder()
                .movieSeq(result.getMovieSeq())
                .movieCd(result.getMovieCd())
                .movieNm(result.getMovieNm())
                .openDt(result.getOpenDt())
                .audiAcc(result.getAudiAcc())
                .thumbnail(result.getThumbnail())
                .rating(result.getRating())
                .comment(result.getComment())
                .userRating(result.getUserRating())
                .createAt(result.getCreateAt())  //todo: 시간 안나옴
                .update(result.getUpdateAt())
                .userDto(UserDto.builder()
                        .userId(userOptional.get().getUserId())
                        .userName(userOptional.get().getUserName())
                        .build())
                .build();
        return favMovieDto;
    }

    @Override
    public Boolean deleteFvMovie(Long userId, Long movieSeq) {
        if (!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if (!favMovieRepository.existsById(movieSeq))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<FavMovie> favMovieOptional = favMovieRepository.findById(movieSeq);
        favMovieRepository.delete(favMovieOptional.get());
        return true;
    }


}
