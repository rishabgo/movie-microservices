package com.rishabh.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Rating {
    private String movieId;
    private int rating;
}
