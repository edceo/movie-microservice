package com.edsoft.controller;

import com.edsoft.domain.Movie;
import com.edsoft.domain.Search;
import com.edsoft.service.MovieService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edsoft on 12/16/16.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @RequestMapping(value = "/detail/", method = RequestMethod.GET)
    public ModelAndView getMovieDetailByName(@ModelAttribute("movie") Movie movie) {
        Movie m = movieService.detailByName(movie.getTitle());
        if (m.getImdbID().isEmpty()) {
            return new ModelAndView("error");
        }
        return new ModelAndView("detail", "movie", m);
    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public ModelAndView getMovieSearchByName(@ModelAttribute("movie") Movie movie) {
        String seasons = movie.getTotalSeasons();
        if (movie.getTitle().isEmpty() || (seasons.isEmpty() && !NumberUtils.isNumber(seasons))) {
            return new ModelAndView("error");
        }
        Search s = movieService.searchMovieByNameAndSeason(movie.getTitle(), Integer.parseInt(movie.getTotalSeasons()));
        if (s.getEpisodes().length == 0) {
            return new ModelAndView("error");
        }
        return new ModelAndView("search", "search", s.getEpisodes());
    }

}
