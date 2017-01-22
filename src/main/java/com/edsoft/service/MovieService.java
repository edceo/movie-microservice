package com.edsoft.service;

import com.edsoft.domain.Movie;
import com.edsoft.domain.Search;

/**
 * Created by yusuf on 12.11.2016.
 */

public interface MovieService {
    Movie detailMovieById(int id);

    Movie detailMovieByImdbId(String imdbId);

    Movie detailByName(String name);

    Search searchMovieByName(String name);

    Search searchMovieByNameAndSeason(String name, int season);

    Search searchMovieByIdAndSeason(String imdbId, int season);
}
