package com.ra.session02.model.service;

import com.ra.session02.model.entity.Movie;
import com.ra.session02.model.entity.ScreenRoom;
import com.ra.session02.model.entity.Showtime;
import com.ra.session02.model.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService implements IService<Showtime> {

    @Autowired
    private ShowtimeRepository showtimeRepo;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @Override
    public void save(Showtime showtime) {
        if (showtime.getMovie() != null && showtime.getMovie().getId() != null) {
            showtime.setMovie(movieService.findById(showtime.getMovie().getId()));
        }
        if (showtime.getScreenRoom() != null && showtime.getScreenRoom().getId() != null) {
            showtime.setScreenRoom(screenRoomService.findById(showtime.getScreenRoom().getId()));
        }
        showtimeRepo.save(showtime);
    }

    @Override
    public Showtime findById(Long id) {
        return showtimeRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Showtime showtime) {
        showtimeRepo.save(showtime);
    }

    @Override
    public void delete(Long id) {
        showtimeRepo.deleteById(id);
    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepo.findAll();
    }
}
