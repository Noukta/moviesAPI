package dev.noukta.movies.service;

import dev.noukta.movies.model.Movie;
import dev.noukta.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> allMovies(int page,
                                 int size){
        Pageable pageable = PageRequest.of(
                page,
                size
        );
        return movieRepository.findAll(pageable);
    }

    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieByImdbId(int imdbId) {
        return movieRepository.findByImdb_ImdbId(imdbId);
    }
}
