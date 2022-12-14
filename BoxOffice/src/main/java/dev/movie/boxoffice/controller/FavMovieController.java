package dev.movie.boxoffice.controller;
import dev.movie.boxoffice.service.FavMovieService;
import dev.movie.boxoffice.dto.FavMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("movie")
public class FavMovieController {
    private final FavMovieService movieService;

    @PostMapping()
    public ResponseEntity<FavMovieDto> createMovie(@RequestParam Long userId,
                                                    @RequestBody FavMovieDto dto){
        FavMovieDto result = this.movieService.createFvMovie(userId, dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FavMovieDto>> readAllMovie(){
        List<FavMovieDto> favMovieDtoList = this.movieService.readAllFvMovie();
        if (favMovieDtoList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(favMovieDtoList);
    }

    @GetMapping()
    public ResponseEntity<List<FavMovieDto>> readMovie(@RequestParam Long userId){
        List<FavMovieDto> favMovieDtoList = this.movieService.readUserFvMovie(userId);
        if (favMovieDtoList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(favMovieDtoList);
    }


    @PutMapping("/{movieSeq}")
    public ResponseEntity<FavMovieDto> updateMovie(@PathVariable("movieSeq") Long movieSeq,
                                                   @RequestParam Long userId,
                                                   @RequestBody FavMovieDto dto){
       FavMovieDto result = this.movieService.updateFvMovie(userId, movieSeq, dto);
            return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{movieSeq}")
    public ResponseEntity<?> deleteMovie(@RequestParam Long userId,
                                                   @PathVariable("movieSeq") Long movieSeq){
        if (!movieService.deleteFvMovie(userId, movieSeq))
            return ResponseEntity.notFound().build();
        return ResponseEntity.notFound().build();
    }
}
