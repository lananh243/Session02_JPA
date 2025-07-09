package com.ra.session02.controller;

import com.ra.session02.model.entity.Movie;
import com.ra.session02.model.entity.ScreenRoom;
import com.ra.session02.model.entity.Showtime;
import com.ra.session02.model.service.MovieService;
import com.ra.session02.model.service.ScreenRoomService;
import com.ra.session02.model.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String showtimes(Model model) {
        List<Showtime> showtimes = showtimeService.findAll();
        model.addAttribute("showtimes", showtimes);
        return "showtime-list";
    }

    @GetMapping("/add")
    public String showFormAddShowtime(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", screenRoomService.findAll());

        return "showtime-add";
    }

    @PostMapping("/add")
    public String addShowtime(Showtime showtime) {
        Long movieId = showtime.getMovie().getId();
        Long screenRoomId = showtime.getScreenRoom().getId();

        showtime.setMovie(movieService.findById(movieId));
        showtime.setScreenRoom(screenRoomService.findById(screenRoomId));

        showtimeService.save(showtime);
        return "redirect:/showtimes";
    }

    @GetMapping("/edit/{id}")
    public String showFormEditShowtime(Model model, @PathVariable Long id) {
        Showtime showtime = showtimeService.findById(id);
        model.addAttribute("showtime", showtime);
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", screenRoomService.findAll());
        return "showtime-edit";
    }

    @PostMapping("/edit")
    public String editShowtime(Showtime showtime) {
        Long movieId = showtime.getMovie().getId();
        Long screenRoomId = showtime.getScreenRoom().getId();

        showtime.setMovie(movieService.findById(movieId));
        showtime.setScreenRoom(screenRoomService.findById(screenRoomId));

        showtimeService.update(showtime);
        return "redirect:/showtimes";
    }

    @GetMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.delete(id);
        return "redirect:/showtimes";
    }
}
