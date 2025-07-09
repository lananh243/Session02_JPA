package com.ra.session02.model.service;

import com.ra.session02.model.entity.ScreenRoom;
import com.ra.session02.model.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomService implements IService<ScreenRoom> {
    @Autowired
    private ScreenRoomRepository screenRoomRepo;

    @Override
    public void save(ScreenRoom entity) {
        screenRoomRepo.save(entity);
    }

    @Override
    public ScreenRoom findById(Long id) {
        return screenRoomRepo.findById(id).orElse(null);
    }

    @Override
    public void update(ScreenRoom entity) {
        screenRoomRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        screenRoomRepo.deleteById(id);
    }

    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepo.findAll();
    }
}
