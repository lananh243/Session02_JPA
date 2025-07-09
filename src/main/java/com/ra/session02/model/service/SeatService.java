package com.ra.session02.model.service;

import com.ra.session02.model.entity.Seat;
import com.ra.session02.model.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements IService<Seat> {
    @Autowired
    private SeatRepository seatRepo;

    @Override
    public void save(Seat entity) {
        seatRepo.save(entity);
    }

    @Override
    public Seat findById(Long id) {
        return seatRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Seat entity) {
        seatRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        seatRepo.deleteById(id);
    }

    @Override
    public List<Seat> findAll() {
        return seatRepo.findAll();
    }
}
