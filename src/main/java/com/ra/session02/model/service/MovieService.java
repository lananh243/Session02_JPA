package com.ra.session02.model.service;

import com.ra.session02.model.entity.Movie;
import com.ra.session02.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IService<Movie> {

    @Autowired
    private MovieRepository movieRepo;

    @Override
    public void save(Movie entity) {
        movieRepo.save(entity);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Movie entity) {
        movieRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }
}
