package com.ra.session02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;
    private String title;
    private String genre;
    private Integer duration;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimes;
}
