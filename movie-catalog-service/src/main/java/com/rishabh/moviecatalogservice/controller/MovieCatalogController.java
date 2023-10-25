package com.rishabh.moviecatalogservice.controller;


import com.rishabh.moviecatalogservice.model.CatalogItem;
import com.rishabh.moviecatalogservice.model.Movie;
import com.rishabh.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@RestController
public class MovieCatalogController {

    @Value("${movieInfoServiceUrl}")
    private String movieInfoServiceUrl;
    @Autowired
    private RestTemplate restTemplate;

    private static final Map<String, List<Rating>> userRatings = new HashMap<>();

    static {
        userRatings.put("1", asList(Rating.builder().movieId("101").rating(4).build(),
                Rating.builder().movieId("102").rating(7).build()));
        userRatings.put("2", singletonList(Rating.builder().movieId("102").rating(9).build()));
    }

    @GetMapping("/catalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        return userRatings.get(userId)
                .stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject(movieInfoServiceUrl + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getMovieName(), movie.getMovieDescription(), rating.getRating());
                }).collect(toList());

    }

}
