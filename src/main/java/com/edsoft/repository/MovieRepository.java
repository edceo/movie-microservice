package com.edsoft.repository;

import com.edsoft.domain.Movie;
import com.edsoft.domain.Search;

/**
 * Created by yusuf on 12.11.2016.
 */

public interface MovieRepository {

    Movie detailById(int id);

    Movie detailByImdbId(String imdbId);

    Movie detailByName(String name);

    Search searchByName(String name);

    Search searchByNameAndSeason(String name, int season);

    Search searchByIdAndSeason(String imdbId, int season);
}
