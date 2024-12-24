package dev.noukta.movies.controller;

import dev.noukta.movies.service.MovieService;
import dev.noukta.movies.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<Movie>> getAllMovies(@PathVariable int page){
        return new ResponseEntity<>(movieService.allMovies(page, 10), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id){
        return new ResponseEntity<>(movieService.singleMovie(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable int id){
        return new ResponseEntity<>(movieService.getMovieByImdbId(id), HttpStatus.OK);
    }
}
