package com.ra.session02.model.service;

import jakarta.persistence.Entity;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    void save(T entity);
    T findById(Long id);
    void update(T entity);
    void delete(Long id);
    List<T> findAll();
}
