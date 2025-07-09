package com.ra.session02.controller;

import com.ra.session02.model.entity.Movie;
import com.ra.session02.model.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String movies(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movie-list";
    }

    @GetMapping("/add")
    public String showFormMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-add";
    }

    @PostMapping("/add")
    public String addMovie(Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showFormEditMovie(Model model, @PathVariable Long id) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movie-edit";
    }

    @PostMapping("/edit")
    public String editMovie(Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}
