package com.ra.session02.model.service;

import com.ra.session02.model.entity.Theater;
import com.ra.session02.model.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService implements IService<Theater> {
    @Autowired
    private TheaterRepository theaterRepo;

    @Override
    public void save(Theater entity) {
        theaterRepo.save(entity);
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Theater entity) {
        theaterRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        theaterRepo.deleteById(id);
    }

    @Override
    public List<Theater> findAll() {
        return theaterRepo.findAll();
    }
}
