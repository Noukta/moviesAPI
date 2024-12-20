package dev.noukta.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
