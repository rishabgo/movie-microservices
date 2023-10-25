package com.rishabh.movieinfoservice.controller;

import com.rishabh.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    private static final Map<String, Movie> movieMap = new HashMap<>();

    static {
        movieMap.put("1234", new Movie("1234", "Transformers", "Transformers movie description"));
        movieMap.put("4567", new Movie("5678", "Mission Impossible", "Mission impossible movie description"));
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        return movieMap.get(movieId);
    }
}
