package dev.movie.boxoffice.controller;
import dev.movie.boxoffice.service.FavMovieService;
import dev.movie.boxoffice.dto.FavMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("api/v1/movie")
public class FavMovieController {
    private final FavMovieService movieService;

    //api/v1/movie?userSeq={1}
    @PostMapping()
    public ResponseEntity<FavMovieDto> createMovie(@RequestParam Long userSeq,
                                                    @RequestBody FavMovieDto dto){
        FavMovieDto result = this.movieService.createFvMovie(userSeq, dto);
        return ResponseEntity.ok(result);
    }

    //전체 영화조회 *제외해도 됨
    @GetMapping("/like")
    public ResponseEntity<List<FavMovieDto>> readAllMovie(){
        List<FavMovieDto> favMovieDtoList = this.movieService.readAllFvMovie();
        if (favMovieDtoList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(favMovieDtoList);
    }

    //유저가 선택한 관심영화조회  *아직작업중
    @GetMapping()
    public ResponseEntity<List<FavMovieDto>> readMovie(@RequestParam(name = "userId")Long userSeq){
        List<FavMovieDto> favMovieDtoList = this.movieService.readUserFvMovie(userSeq);
        if (favMovieDtoList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(favMovieDtoList);
    }


    @PutMapping("/{movieSeq}")
    public ResponseEntity<FavMovieDto> updateMovie(@PathVariable("movieSeq") Long movieSeq,
                                                   @RequestParam Long userSeq,
                                                   @RequestBody FavMovieDto dto){
       FavMovieDto result = this.movieService.updateFvMovie(userSeq, movieSeq, dto);
            return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{movieSeq}")
    public ResponseEntity<?> deleteMovie(@RequestParam Long userSeq,
                                                   @PathVariable("movieSeq") Long movieSeq){

        if (!movieService.deleteFvMovie(userSeq, movieSeq))
            return ResponseEntity.notFound().build();
        return ResponseEntity.notFound().build();
    }
}
