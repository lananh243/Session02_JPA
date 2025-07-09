package com.ra.session02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private Long id;
    private String seatNumber;
    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;

}
