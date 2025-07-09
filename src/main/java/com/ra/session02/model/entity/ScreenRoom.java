package com.ra.session02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"theater", "seats", "showtimes"})
public class ScreenRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "screen_room_id")
    private Long id;
    private String name;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "screenRoom", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "screenRoom", cascade = CascadeType.ALL)
    private List<Showtime> showtimes;
}
