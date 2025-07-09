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
@ToString(exclude = "screenRooms")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "theater_id")
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<ScreenRoom> screenRooms;
}
